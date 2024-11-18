package se.lexicon.data.dao;

import se.lexicon.model.TodoItem;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class TodoItemDAOCollection implements TodoItemDAO {

    private Collection<TodoItem> todoItems;

    public TodoItemDAOCollection(){
        this.todoItems=new HashSet<>();
    }
    @Override
    public TodoItem persist(TodoItem todoItem) {
        if(todoItem !=null && todoItems.add(todoItem)){
            return todoItem;
        }

        return null;
    }

    @Override
    public TodoItem findById(int id) {
        for(TodoItem todoItem:todoItems){
            if (todoItem.getId() == id) {
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return Collections.unmodifiableCollection(todoItems);
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean done) {
        Collection<TodoItem> todoItemDone=new HashSet<>();
        for(TodoItem todoItem:todoItems){
            if(todoItem.isDone()==done){
                todoItemDone.add(todoItem);
            }
        }
        return todoItemDone;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {

        Collection<TodoItem> todoItemList=new HashSet<>();
        for(TodoItem todoItem:todoItems){
            if(todoItem.getTitle().trim().equalsIgnoreCase(title)){
                todoItemList.add(todoItem);
            }
        }
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        Collection<TodoItem> todoItemList=new HashSet<>();
        for(TodoItem todoItem:todoItems){
            if(todoItem.getCreator().getId()==personId){
                todoItemList.add(todoItem);
            }
        }
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByDeadLineBefore(LocalDate date) {
        Collection<TodoItem> todoItemDeadLineBefore=new HashSet<>();
        for(TodoItem todoItem:todoItems){
            if(todoItem.getDeadLine().isBefore(date)){
                todoItemDeadLineBefore.add(todoItem);
            }
        }
        return todoItemDeadLineBefore;
    }

    @Override
    public Collection<TodoItem> findByDeadLineAfter(LocalDate date) {
        Collection<TodoItem> todoItemDeadLineAfter=new HashSet<>();
        for(TodoItem todoItem:todoItems){
            if(todoItem.getDeadLine().isAfter(date)){
                todoItemDeadLineAfter.add(todoItem);
            }
        }
        return todoItemDeadLineAfter;
    }

    @Override
    public void remove(int id) {
        TodoItem todoItem=findById(id);
        if(todoItem != null){
            todoItems.remove(todoItem);
        }

    }
}
