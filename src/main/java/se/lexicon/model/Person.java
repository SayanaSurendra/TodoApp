package se.lexicon.model;

import se.lexicon.util.IdGenerator;


public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;


   public Person(String firstName, String lastName, String email) {
        this.id = IdGenerator.nextId();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
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

    public String getSummary(){
        StringBuilder sb=new StringBuilder();
        sb.append("{ id: ");
        sb.append(id);
        sb.append(" , name: ");
        sb.append(firstName);
        sb.append(" ");
        sb.append(lastName);
        sb.append(" , email: ");
        sb.append(email);
        sb.append("}");
        return sb.toString();
    }
}
