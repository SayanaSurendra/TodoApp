package se.lexicon;

import se.lexicon.data.dao.People;
import se.lexicon.data.dao.TodoItems;
import se.lexicon.data.dao.impl.PeopleImpl;
import se.lexicon.data.dao.impl.TodoItemsImpl;
import se.lexicon.db.MYSQLConnection;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.sql.Connection;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Connection connection= MYSQLConnection.getConnection();

        People people=new PeopleImpl(connection);
        /*Person person=new Person("Fredrik","Svensson");
        Person person=new Person("Sayana","Surendran");
        Person person=new Person("Mathews","Svensson");*/
        Person person=new Person("Anna","Svensson");
        people.create(person);
        System.out.println(people.findById(2));
        System.out.println(people.findByName("Mathews"));
        System.out.println(people.findAll());
        Person person1=people.findById(3);
        person.setLastName("Johnsson");
        System.out.println(people.update(person1));
        people.deleteById(4);
        System.out.println(people.findAll());



        TodoItems todoItem=new TodoItemsImpl(connection);
        //Todo todo=new Todo("Change tires","Need to change tires", LocalDate.of(2025,1,9),false,2);
       // Todo todo=new Todo("Cooking","Need to cook Lunch", LocalDate.of(2025,1,11),false);
       // Todo todo=new Todo("Groceries","Need to buy groceries", LocalDate.of(2025,1,5),false,2);
       // Todo todo=new Todo("Complete Homework","Finish Science exercises", LocalDate.of(2025,1,5),false);
       // Todo todo=new Todo("Meeting","Discussion about courses", LocalDate.of(2025,2,3),false,1);
        //todoItem.create(todo);



        System.out.println(todoItem.findAll());
        System.out.println("====================================");
        System.out.println(todoItem.findByAssignee(people.findById(1)));
        System.out.println("====================================");
           System.out.println(todoItem.findByAssignee(2));
        System.out.println("====================================");
        Todo todo=todoItem.findById(1);
        todo.setDone(true);
        todoItem.update(todo);
        System.out.println("<====================================>");
        System.out.println(todoItem.findByDoneStatus(false));
        System.out.println("====================================");
        System.out.println(todoItem.findByUnassignedTodoItems());
        todoItem.deleteById(4);

        System.out.println("====================================");




    }
}