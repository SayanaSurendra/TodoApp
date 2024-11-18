package se.lexicon.data.dao;

import se.lexicon.model.Person;

import java.util.Collection;

public interface PersonDAO {
    Person persist(Person person);
    Person findById(int id);
    Person findbyEmail(String email);
    Collection<Person> findAll();
    void remove(int id);
}
