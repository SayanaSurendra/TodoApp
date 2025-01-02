package se.lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
       person=new Person("Sayana","Surendran");
    }


   @Test
   void testConstructPerson(){
        assertEquals("Sayana",person.getFirstName());
        assertEquals("Surendran",person.getLastName());

   }

   @Test
   void testGettersSetters(){
        person.setFirstName("Erik");
        person.setLastName("Svensson");

        assertEquals("Erik",person.getFirstName());
        assertEquals("Svensson",person.getLastName());

   }



    @Test
    void testNullFirstName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(null,"Surendran");
        });
    }
}