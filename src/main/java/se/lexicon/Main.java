package se.lexicon;

import se.lexicon.data.dao.*;
import se.lexicon.model.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        AppUser appUser1=new AppUser("Erik","Erik@123", AppRole.ROLE_APP_ADMIN);

        AppUser appUser2=new AppUser("Fedrik","fedrik@123", AppRole.ROLE_APP_USER);

        Person person=new Person("Sayana","Surendran","sayana@gmail.com",appUser1);
        Person person2=new Person("Steve","Svensson","steve@gmail.com",appUser2);

        TodoItem todoItem=new TodoItem("Change tires","Need to change tires", LocalDate.of(2024,11,11),person);
        TodoItem todoItem1=new TodoItem("Groceries","Need to buy groceries", LocalDate.of(2024,11,20),person2);

        TodoItemTask task1= new TodoItemTask(todoItem,person);
        System.out.println(task1);

        System.out.println( appUser1.toString());
        System.out.println( person.toString());

        todoItem.setDone(true);
        if(todoItem.isOverdue()){
            System.out.println("TodoItem is overdue");
        }else{
            System.out.println("Deadline is not over");
        }




        AppUserDAO appUserDAO=new AppUserDAOCollection();
        appUserDAO.persist(appUser1);
        appUserDAO.persist(appUser2);
        System.out.println("List of appUsers: "+appUserDAO.findAll());
        System.out.println(appUserDAO.findByUsername("erik"));
        appUserDAO.remove("erik");
        System.out.println("List of appUsers: "+appUserDAO.findAll());
        System.out.println("==========================");

        TodoItemDAO todoItemDAO=new TodoItemDAOCollection();
        todoItemDAO.persist(todoItem1);
        todoItemDAO.persist(todoItem);
        System.out.println("Todoitem by id: "+todoItemDAO.findById(todoItem1.getId()));
        System.out.println("TodoItem deadline: "+ todoItemDAO.findByDeadLineAfter(LocalDate.of(2024,11,19)));
        System.out.println("TodoItem by personId: "+todoItemDAO.findByPersonId(todoItem1.getCreator().getId()));
        System.out.println("List of todoitems: "+ todoItemDAO.findAll());
        System.out.println("Task before deadline:"+ todoItemDAO.findByDeadLineBefore(LocalDate.of(2024,11,21)));
        System.out.println("==========================");

        TodoItemTaskDAO todoItemTaskDAO=new TodoItemTaskDAOCollection();
        todoItemTaskDAO.persist(task1);
        System.out.println("TodoItemTaskDAO:::" +todoItemTaskDAO.findAll());
        System.out.println(todoItemTaskDAO.findByAssignedStatus(false));
        System.out.println(todoItemTaskDAO.findByPersonId(task1.getAssignee().getId()));


    }
}