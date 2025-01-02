package se.lexicon.data.dao;

import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.util.Collection;

public interface TodoItems {
    Todo create(Todo todo);
    Collection<Todo> findAll();
    Todo findById(int id);
    Collection<Todo> findByDoneStatus(boolean status);
    Collection<Todo> findByAssignee(int assignedId);
    Collection<Todo> findByAssignee(Person person);
    Collection<Todo> findByUnassignedTodoItems();
    Todo update(Todo todo);
    boolean deleteById(int id);
}
