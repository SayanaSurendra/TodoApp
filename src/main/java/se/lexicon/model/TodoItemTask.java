package se.lexicon.model;

import se.lexicon.data.sequencers.TodoItemTaskIdSequencer;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private Todo todoItem;
    private Person assignee;
    private boolean assigned;


    public TodoItemTask(Todo todoItem, Person assignee) {
        this.id= TodoItemTaskIdSequencer.nextId();
        this.todoItem = todoItem;
        this.setAssignee(assignee);

    }

    public int getId() {
        return id;
    }

      public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;

    }

    public Todo getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(Todo todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("TodoItem must not be null");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        if(assignee != null){
            this.assigned=true;
        }
        else{
            this.assigned=false;
        }
    }




    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", todoItem=" + todoItem +
                ", assigned=" + assigned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id && assigned == that.assigned && Objects.equals(todoItem, that.todoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, todoItem, assigned);
    }
}
