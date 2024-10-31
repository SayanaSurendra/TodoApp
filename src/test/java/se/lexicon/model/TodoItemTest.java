package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    private Person person;
    private TodoItem todoItem;
    private TodoItem overdueItem;

    @BeforeEach
    void setUp() {
        person=new Person("Sayana","Surendran","sayana@gmail.com");
        todoItem=new TodoItem("Change tires","Need to change the tires for winter", LocalDate.of(2024,11,11),person);
    }


    @Test
    void testConstructTodoItem(){
        assertEquals("Change tires",todoItem.getTitle());
        assertEquals("Need to change the tires for winter",todoItem.getTaskDescription());
        assertEquals(LocalDate.of(2024,11,11),todoItem.getDeadLine());
        assertFalse(todoItem.isDone());
        assertEquals(person,todoItem.getCreator());
    }

    @Test
    void testSetDone() {
        assertFalse(todoItem.isDone());
        todoItem.setDone(true);
        assertTrue(todoItem.isDone());

    }

    @Test
    void testIsOverdue() {
        overdueItem=new TodoItem("Cleaning Car","Car needs to washed and serviced",LocalDate.of(2024,10,5),person);
        assertTrue(overdueItem.isOverdue());
        assertFalse(todoItem.isOverdue());
    }
}