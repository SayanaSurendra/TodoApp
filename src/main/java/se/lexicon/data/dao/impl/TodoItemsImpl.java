package se.lexicon.data.dao.impl;

import se.lexicon.data.dao.People;
import se.lexicon.data.dao.TodoItems;
import se.lexicon.db.MYSQLConnection;
import se.lexicon.exception.MySQLException;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemsImpl implements TodoItems {


    private Connection connection;

    public TodoItemsImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Todo create(Todo todo) {
        String CREATE_TODO_SQL="INSERT INTO todo_item (title,description,deadline,done,assignee_id) VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TODO_SQL,Statement.RETURN_GENERATED_KEYS);) {


            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf(todo.getDeadLine()));
            preparedStatement.setBoolean(4, todo.isDone());
            if(todo.getAssigned_id() != null) {
                preparedStatement.setInt(5, todo.getAssigned_id());
            }else{
                preparedStatement.setNull(5,Types.NULL);
            }


            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0){
                throw new MySQLException("Todo creation failed");
            }
            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys();){
                if(generatedKeys.next()){
                    int generatedId= generatedKeys.getInt(1);
                    return new Todo(generatedId,todo.getTitle(), todo.getTaskDescription(), todo.getDeadLine(),todo.isDone(),todo.getAssigned_id());
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        String FIND_ALL_SQL="SELECT * FROM todo_item";

        List<Todo> todoItems=new ArrayList<>();
        try(  Statement statement=connection.createStatement();
              ResultSet resultSet =statement.executeQuery(FIND_ALL_SQL);
        ) {
            while(resultSet.next()){
                int id=resultSet.getInt("todo_id");
                String title=resultSet.getString("title");
                String description=resultSet.getString("description");
                LocalDate deadline=resultSet.getDate("deadline").toLocalDate();
                Boolean status=resultSet.getBoolean("done");
                Integer assigned_Id=resultSet.getInt("assignee_id");

                todoItems.add(new Todo(id,title,description,deadline,status,assigned_Id));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public Todo findById(int id) {
        String FIND_BY_TODO_ID_SQL="SELECT * FROM todo_item WHERE todo_id=?";


        try(  PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_TODO_ID_SQL);
        ) {
            preparedStatement.setInt(1,id);
            try (ResultSet resultSet =preparedStatement.executeQuery();){
                while(resultSet.next()){
                    int todoId=resultSet.getInt("todo_id");
                    String title=resultSet.getString("title");
                    String description=resultSet.getString("description");
                    LocalDate deadline=resultSet.getDate("deadline").toLocalDate();
                    boolean status=resultSet.getBoolean("done");
                    Integer assigned_Id=resultSet.getInt("assignee_id");

                    return new Todo(id,title,description,deadline,status,assigned_Id);
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
       // return todos;
       return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean status) {

        String FIND_BY_DONE_SQL="SELECT * FROM todo_item WHERE done=?";

        List<Todo> todos=new ArrayList<>();
        try(  PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_DONE_SQL);
        ) {
            preparedStatement.setBoolean(1,status);
            try (ResultSet resultSet =preparedStatement.executeQuery();){
                while(resultSet.next()){
                    int id=resultSet.getInt("todo_id");
                    String title=resultSet.getString("title");
                    String description=resultSet.getString("description");
                    LocalDate deadline=resultSet.getDate("deadline").toLocalDate();
                    boolean currentStatus=resultSet.getBoolean("done");
                    Integer assignee_id=resultSet.getInt("assignee_id");
                    todos.add(new Todo(id,title,description,deadline,currentStatus,assignee_id));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    @Override
    public Collection<Todo> findByAssignee(int assignedId) {
        String FIND_BY_ASSIGNEE_ID_SQL="SELECT * FROM todo_item WHERE assignee_id=?";

        List<Todo> todos=new ArrayList<>();
        try(  PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_ASSIGNEE_ID_SQL);
        ) {
            preparedStatement.setInt(1,assignedId);
            try (ResultSet resultSet =preparedStatement.executeQuery();){
                while(resultSet.next()){
                    int id=resultSet.getInt("todo_id");
                    String title=resultSet.getString("title");
                    String description=resultSet.getString("description");
                    LocalDate deadline=resultSet.getDate("deadline").toLocalDate();
                    Boolean status=resultSet.getBoolean("done");
                    Integer assignee_id=resultSet.getInt("assignee_id");
                    todos.add(new Todo(id,title,description,deadline,status,assignee_id));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;

    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        String FIND_BY_ASSIGNEE_SQL="SELECT * FROM todo_item WHERE assignee_id=?";

        List<Todo> todos=new ArrayList<>();
        try(  PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_ASSIGNEE_SQL);
        ) {
            preparedStatement.setInt(1,person.getId());
            try (ResultSet resultSet =preparedStatement.executeQuery();){
                while(resultSet.next()){
                    int id=resultSet.getInt("todo_id");

                    String title=resultSet.getString("title");
                    String description=resultSet.getString("description");
                    LocalDate deadline=resultSet.getDate("deadline").toLocalDate();
                    Boolean status=resultSet.getBoolean("done");
                    Integer assignee_id=resultSet.getInt("assignee_id");
                    todos.add(new Todo(id,title,description,deadline,status,assignee_id));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;

    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        String FIND_BY_UNASSIGNED_TODOITEMS_SQL="SELECT * FROM todo_item WHERE assignee_id IS NULL";

        List<Todo> todos=new ArrayList<>();
        try(  Statement statement=connection.createStatement();
        ) {

            try (ResultSet resultSet = statement.executeQuery(FIND_BY_UNASSIGNED_TODOITEMS_SQL);){
                while(resultSet.next()){
                    int id=resultSet.getInt("todo_id");
                    String title=resultSet.getString("title");
                    String description=resultSet.getString("description");
                    LocalDate deadline=resultSet.getDate("deadline").toLocalDate();
                    Boolean status=resultSet.getBoolean("done");
                    int assignee_id=resultSet.getInt("assignee_id");

                    todos.add(new Todo(id,title,description,deadline,status,assignee_id));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;

    }

    @Override
    public Todo update(Todo todo) {
        String UPDATE_SQL="UPDATE todo_item  SET  title = ?,description = ?,deadline = ?,done = ? , assignee_id =? WHERE todo_id=? ";

        try(
                PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_SQL);
        ){

            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf(todo.getDeadLine()));
            preparedStatement.setBoolean(4, todo.isDone());
            if(todo.getAssigned_id() != null) {
                preparedStatement.setInt(5, todo.getAssigned_id());
            }else{
                preparedStatement.setNull(5,Types.NULL);
            }
            preparedStatement.setInt(6, todo.getId());
            int rowsUpdated=preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Todo updated successfully.");
            } else {
                System.out.println("No todo item found with that ID.");
            }
            return todo;



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String DELETE_SQL="DELETE FROM todo_item WHERE todo_id=?";
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
