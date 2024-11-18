package se.lexicon.data.dao;

import se.lexicon.model.Person;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class PersonDAOCollection implements PersonDAO {

    private Collection<Person> persons;

    public PersonDAOCollection(){
        this.persons=new HashSet<>();
    }
    @Override
    public Person persist(Person person) {
        if(person !=null && persons.add(person)){
            return person;
        }

        return null;
    }

    @Override
    public Person findById(int id) {
        for(Person person:persons){
          if(person.getId()==id){
              return person;
          }
        }
        return null;
    }

    @Override
    public Person findbyEmail(String email) {
        for(Person person:persons){
            if(person.getEmail().trim().equalsIgnoreCase(email)){
                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.unmodifiableCollection(persons);
    }

    @Override
    public void remove(int id) {
        Person person=findById(id);
        if(person != null){
            persons.remove(person);
        }
    }
}
