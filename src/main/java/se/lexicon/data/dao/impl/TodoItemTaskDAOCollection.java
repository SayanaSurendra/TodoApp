package se.lexicon.data.dao.impl;

import se.lexicon.data.dao.TodoItemTaskDAO;
import se.lexicon.model.TodoItemTask;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    private Collection<TodoItemTask> todoItemTasks;

    public TodoItemTaskDAOCollection(){
        this.todoItemTasks=new HashSet<>();
    }
    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        if(todoItemTask !=null && todoItemTasks.add(todoItemTask)){
            return todoItemTask;
        }
        return null;
    }

    @Override
    public TodoItemTask findById(int id) {
        for(TodoItemTask todoItemTask:todoItemTasks){
            if (todoItemTask.getId() == id) {
                return todoItemTask;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return Collections.unmodifiableCollection(todoItemTasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {

        Collection<TodoItemTask> todoItemTaskList = new HashSet<>();
        for (TodoItemTask todoItemTask : todoItemTasks) {
            if (todoItemTask.isAssigned() == status) {
                todoItemTaskList.add(todoItemTask);
            }

        }
        return todoItemTaskList;
    }


    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Collection<TodoItemTask> todoItemTaskList=new HashSet<>();
        for(TodoItemTask todoItemTask:todoItemTasks){
            if(todoItemTask.getAssignee().getId()==personId){
                todoItemTaskList.add(todoItemTask);
            }
        }
        return todoItemTaskList;
    }

    @Override
    public void remove(int id) {
        TodoItemTask todoItemTask=findById(id);
        if(todoItemTask != null){
            todoItemTasks.remove(todoItemTask);
        }
    }
}
