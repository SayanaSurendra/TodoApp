package se.lexicon.model;

import java.util.Objects;


public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private AppUser credentials;


    public Person(String firstName, String lastName, AppUser credentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentials = credentials;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
       return id;
    }

    public String getFirstName() {
       return firstName;
    }

    public void setFirstName(String firstName) {
      if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("First name cannot be empty");
        this.firstName = firstName;
    }

    public String getLastName() {
       return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Last name cannot be empty");
        this.lastName = lastName;
    }


    public AppUser getCredentials() {
       return credentials;
    }

    public void setCredentials(AppUser credentials) {
       this.credentials = credentials;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName());
    }
}
