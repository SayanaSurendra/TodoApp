package se.lexicon.model;

import se.lexicon.util.IdGenerator;

public class TodoItemTask {
    private int id;
    private  TodoItem todoItem;
    private Person assignee;
    private boolean assigned;


    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this.id= IdGenerator.nextId();
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

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
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



    public String getSummary(){
        StringBuilder sb=new StringBuilder();
        sb.append("{ id: ");
        sb.append(id);
        sb.append(" , assigned: ");
        sb.append(assigned);
        sb.append(" , todoItem: ");
        sb.append(todoItem.getSummary());
        sb.append(" , assignee: ");
        sb.append(assignee != null ? assignee.getFirstName()+" "+assignee.getLastName():"Null");
        sb.append("}");
        return sb.toString();
    }
}
