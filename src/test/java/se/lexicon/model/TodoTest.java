package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    private Person person;
    private Todo todoItem;
    private Todo overdueItem;

    @BeforeEach
    void setUp() {
        person=new Person("Sayana","Surendran");
        todoItem=new Todo("Change tires","Need to change the tires for winter", LocalDate.of(2025,1,11),person.getId());
    }


    @Test
    void testConstructTodoItem(){
        assertEquals("Change tires",todoItem.getTitle());
        assertEquals("Need to change the tires for winter",todoItem.getTaskDescription());
        assertEquals(LocalDate.of(2025,1,11),todoItem.getDeadLine());
        assertFalse(todoItem.isDone());
        assertEquals(person.getId(),todoItem.getId());
    }

    @Test
    void testSetDone() {
        assertFalse(todoItem.isDone());
        todoItem.setDone(true);
        assertTrue(todoItem.isDone());

    }

    @Test
    void testIsOverdue() {
        overdueItem=new Todo("Cleaning Car","Car needs to washed and serviced",LocalDate.of(2024,10,5),person.getId());
        assertTrue(overdueItem.isOverdue());
        assertFalse(todoItem.isOverdue());
    }
}