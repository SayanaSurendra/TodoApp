package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Person person=new Person("Sayana","Surendran","sayana@gmail.com");

        TodoItem todoItem=new TodoItem("Change tires","Need to change tires", LocalDate.of(2024,11,11),person);

        System.out.println( person.getSummary());
        System.out.println( todoItem.getSummary());

        todoItem.setDone(true);
        if(todoItem.isOverdue()){
            System.out.println("TodoItem is overdue");
        }else{
            System.out.println("Deadline is not over");
        }


        TodoItemTask task1= new TodoItemTask(todoItem,person);
        System.out.println(task1.getSummary());
        task1.setAssignee(null);
        System.out.println(task1.getSummary());
    }
}