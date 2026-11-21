package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import config.Constants;

public class DataBaseInitiation{
    public static void createDataBase(){
        try (Connection conn = DriverManager.getConnection(Constants.URL)){
            conn.createStatement().execute("PRAGMA foreign_keys = ON;");
            DataBaseInitiation.createTables(conn);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void createTables(Connection connection) throws SQLException {

        connection.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS WordList (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "word TEXT NOT NULL UNIQUE" +
                        ");"
        );

        connection.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS RelatedWords (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "word_id INTEGER NOT NULL, " +
                        "relatedWord_id INTEGER NOT NULL, " +
                        "word TEXT NOT NULL REFERENCES WordList(word), " +
                        "relatedWord TEXT NOT NULL UNIQUE REFERENCES WordList(word), " +
                        "value INTEGER NOT NULL, " +
                        "FOREIGN KEY (word_id) REFERENCES WordList(id), " +
                        "FOREIGN KEY (relatedWord_id) REFERENCES WordList(id)" +
                        "UNIQUE (word, relatedWord)" +
                        ");"
        );
    }
}