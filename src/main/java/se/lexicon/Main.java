package se.lexicon;

import se.lexicon.model.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        AppUser appUser1=new AppUser("Erik","Erik@123", AppRole.ROLE_APP_ADMIN);

        Person person=new Person("Sayana","Surendran","sayana@gmail.com",appUser1);

        TodoItem todoItem=new TodoItem("Change tires","Need to change tires", LocalDate.of(2024,11,11),person);
        System.out.println( appUser1.toString());
       System.out.println( person.toString());

        todoItem.setDone(true);
        if(todoItem.isOverdue()){
            System.out.println("TodoItem is overdue");
        }else{
            System.out.println("Deadline is not over");
        }


        TodoItemTask task1= new TodoItemTask(todoItem,person);
       // System.out.println(task1.getSummary());
        task1.setAssignee(null);
        //System.out.println(task1);
    }
}