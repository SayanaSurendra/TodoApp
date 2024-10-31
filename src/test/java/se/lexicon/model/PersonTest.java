package se.lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
       person=new Person("Sayana","Surendran","sayana@gmail.com");
    }


   @Test
   void testConstructPerson(){
        assertEquals("Sayana",person.getFirstName());
        assertEquals("Surendran",person.getLastName());
        assertEquals("sayana@gmail.com",person.getEmail());
   }

   @Test
   void testGettersSetters(){
        person.setFirstName("Erik");
        person.setLastName("Svensson");
        person.setEmail("Test@gmail.com");
        assertEquals("Erik",person.getFirstName());
        assertEquals("Svensson",person.getLastName());
        assertEquals("Test@gmail.com",person.getEmail());
   }

    @Test
    void getSummary() {
        String expected="{ id: "+person.getId()+" "+", name: Sayana Surendran , email: sayana@gmail.com}";
        assertEquals(expected,person.getSummary());
    }

    @Test
    void testNullFirstName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(null,"Surendran","sayanag@mail.com");
        });
    }
}