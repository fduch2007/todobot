package edu.baiburin.todobot.dao;

import edu.baiburin.todobot.domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TaskInserter {
    public static final String INSERT_TASK =
            "INSERT INTO todotasks(" +
                    "task_id, " +
                    "author_first_name, " +
                    "author_last_name, " +
                    "task_description, " +
                    "create_date, " +
                    "is_archived, " +
                    "finish_date, " +
                    "delete_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

//    private Connection getConnection() throws SQLException {
//        return ConnectionBuilder.getConnection();
//    }


    public void insertTask(Task tsk) throws SQLException {
        try (Connection connection = ConnectionBuilder.getConnection();
             PreparedStatement stmt = connection.prepareStatement(INSERT_TASK)) {
            connection.setAutoCommit(false);
            try {
                stmt.setLong(1, tsk.getTaskId());
                stmt.setString(2, tsk.getAuthorFirstName());
                stmt.setString(3, tsk.getAuthorLastName());
                stmt.setString(4, tsk.getTaskDescription());
                stmt.setTimestamp(5, java.sql.Timestamp.valueOf(LocalDateTime.now()));
                stmt.setBoolean(6, tsk.isArchived());
                stmt.setTimestamp(7, null);
                stmt.setTimestamp(8, null);
                System.out.println(stmt.toString());
                stmt.executeUpdate();


                connection.commit();
            } catch (SQLException ex) {
                System.err.println(ex);
                connection.rollback();
            }
        }
    }
}
