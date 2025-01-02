package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class Todo {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Integer assigned_id;


    public Todo( String title, String taskDescription, LocalDate deadLine, boolean done) {
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.done = done;
    }


    public Todo(String title, String taskDescription, LocalDate deadLine, boolean done,Integer assigned_id) {
        this(title,taskDescription,deadLine,done);
        this.assigned_id=assigned_id;
    }



    public Todo(int id, String title, String description, LocalDate deadline, boolean done, Integer assigned_id) {
        this(title,description,deadline,done,assigned_id);
        this.id=id;

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



    public Integer getAssigned_id() {
        return assigned_id;
    }

    public void setAssigned_id(int assigned_id) {
        this.assigned_id = assigned_id;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }

     @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                ", assignedid=" + assigned_id+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todoItem = (Todo) o;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadLine, todoItem.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine, done);
    }
}
