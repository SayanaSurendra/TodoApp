package se.lexicon.model;

import se.lexicon.util.IdGenerator;

import java.util.Objects;


public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;


   public Person(String firstName, String lastName, String email) {
        this.id = IdGenerator.nextId();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
    }

    public Person(String firstName,String lastName,String email,AppUser credentials){
      this(firstName,lastName,email);
      this.credentials=credentials;
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

    public String getEmail() {
       return email;
    }

    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email cannot be empty");
        this.email = email;
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
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
       return Objects.hash(id, firstName, lastName, email);
    }
}
