package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {
    private Person person;
    private TodoItem todoItem;
    private TodoItemTask taskAssigned;
    private TodoItemTask taskNotAssigned;

    @BeforeEach
    void setUp() {
        person=new Person("Sayana","Surendran","sayana@gmail.com");
        todoItem=new TodoItem("Change tires","Need to change the tires for winter", LocalDate.of(2024,11,11),person);
        taskAssigned= new TodoItemTask(todoItem,person);
        taskNotAssigned=new TodoItemTask(todoItem,null);
    }


    @Test
    void testConstructTodoItemTask(){
        assertEquals(todoItem,taskAssigned.getTodoItem());
        assertTrue(taskAssigned.isAssigned());
        assertEquals(person,taskAssigned.getAssignee());
        assertFalse(taskNotAssigned.isAssigned());
        assertNull(taskNotAssigned.getAssignee());
    }

    @Test
    void testSetAssignee(){
        assertFalse(taskNotAssigned.isAssigned());

        taskNotAssigned.setAssignee(person);
        assertTrue(taskNotAssigned.isAssigned());
        assertEquals(person,taskNotAssigned.getAssignee());
    }

}