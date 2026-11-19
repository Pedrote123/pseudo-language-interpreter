package database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseInitiation{
    public static void createDataBase(String directoryUrl){
        String url = String.format("jdbc:sqlite:%s", directoryUrl);

        try (Connection conn = DriverManager.getConnection(url)){
            DataBaseInitiation.createTables(conn);

            conn.createStatement().execute("PRAGMA foreign_keys = ON;");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void createTables(Connection connection) throws SQLException{
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS WordList (" +
                "id INTEGER PRIMARY KEY, " +
                "word TEXT NOT NULL UNIQUE" +
                ");");

        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS RelatedWords (" +
                "id INTEGER PRIMARY KEY, " +
                "word_id INTEGER NOT NULL, " +
                "relatedWordValue_id INTEGER NOT NULL, " +
                "FOREIGN KEY (word_id) REFERENCES (WordList), " +
                "FOREIGN KEY (relatedWordValue_id) REFERENCES RelatedWordsValues(id)"+
                ");");

        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS RelatedWordsValues (" +
                "id INTEGER PRIMARY KEY, " +
                "word_id INTEGER NOT NULL, " +
                "relatedWord_id INTEGER NOT NULL, " +
                "FOREIGN KEY (relatedWord_id) REFERENCES RelatedWords(id)"+
                ");");
    }
}