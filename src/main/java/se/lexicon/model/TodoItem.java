package se.lexicon.model;

import se.lexicon.util.IdGenerator;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    //constructors


    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        this.id= IdGenerator.nextId();
        this.setTitle(title);
        this.taskDescription = taskDescription;
        this.setDeadLine(deadLine);
        this.creator = creator;
        this.done=false;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = Objects.requireNonNull(deadLine);
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }

    public String getSummary(){
        StringBuilder sb=new StringBuilder();
        sb.append("{ id: ");
        sb.append(id);
        sb.append(" , title: ");
        sb.append(title);
        sb.append(", taskDescription: ");
        sb.append(taskDescription);
        sb.append(" , deadLine: ");
        sb.append(deadLine);
        sb.append(" , Done: ");
        sb.append(done);
        sb.append(" , Person: ");
        sb.append(creator.getFirstName());
        sb.append(" ");
        sb.append(creator.getLastName());
        sb.append("}");
        return sb.toString();
    }


}
