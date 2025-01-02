package se.lexicon.data.dao.impl;

import se.lexicon.data.dao.People;
import se.lexicon.exception.MySQLException;
import se.lexicon.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class PeopleImpl implements People {

    private Connection connection;

    public PeopleImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Person create(Person person) {
        String CREATE_PERSON_SQL="INSERT INTO person (first_name,last_name) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PERSON_SQL);) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0){
                throw new MySQLException("Person creation failed");
            }
            return person;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        String FIND_ALL_SQL="SELECT * FROM Person";

        List<Person> persons=new ArrayList<>();
        try(  Statement statement=connection.createStatement();
            ResultSet resultSet =statement.executeQuery(FIND_ALL_SQL);
        ) {
            while(resultSet.next()){
                int id=resultSet.getInt("person_id");
                String firstName=resultSet.getString("first_name");
                String lastName=resultSet.getString("last_name");
                persons.add(new Person(id,firstName,lastName));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person findById(int id) {
        String FIND_BY_ID_SQL="SELECT * FROM person where person_id=?";
        try( PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_ID_SQL);
        ){
            preparedStatement.setInt(1,id);
            try (ResultSet resultSet =preparedStatement.executeQuery();){
                if(resultSet.next()){
                    int person_id=resultSet.getInt("person_id");
                    String firstName=resultSet.getString("first_name");
                    String lastName=resultSet.getString("last_name");
                    return  new Person(person_id,firstName,lastName);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Person> findByName(String name) {
        String FIND_BY_NAME_SQL="SELECT * FROM Person WHERE first_name=? ";

        List<Person> persons=new ArrayList<>();
        try(  PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_NAME_SQL);
        ) {
            preparedStatement.setString(1,name);
            try (ResultSet resultSet =preparedStatement.executeQuery();){
                if(resultSet.next()){
                    int id=resultSet.getInt("person_id");
                    String firstName=resultSet.getString("first_name");
                    String lastName=resultSet.getString("last_name");
                    persons.add(new Person(id,firstName,lastName));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person update(Person person) {
        String UPDATE_SQL="UPDATE person  SET first_name= ? , last_name=? WHERE person_id=? ";

        try(
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_SQL);
        ){

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getId());
            int rowsUpdated=preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with that ID.");
            }
            return person;



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String DELETE_SQL="DELETE from person WHERE person_id=?";
        try(
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_SQL);
        ){
            preparedStatement.setInt(1,id);
            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows==1) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
