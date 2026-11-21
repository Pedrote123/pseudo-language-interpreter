package database;

import config.Constants;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseInteraction{
    public static Connection conn;

    static{
        try{
            conn = DriverManager.getConnection(Constants.URL);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public static void addWord(String word){
        try {
            conn.createStatement().execute(
                    String.format("INSERT INTO WordList (word) VALUES ('%s');", word)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addWords(ArrayList<String> words){
        for (String word : words){
            addWord(word);
        }
    }

    public static void removeWord(String word){
        try{
            conn.createStatement().execute(
                    String.format("DELETE FROM WordList WHERE word = '%s'", word)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void addRelationship(String word, String relatedWord, Integer value){
        try{
            conn.createStatement().execute(
                    String.format("INSERT INTO RelatedWords (word_id, relatedWord_id, word, relatedWord, value) VALUES (" +
                            "(SELECT id FROM WordList WHERE word = '%1$s'), " +
                            "(SELECT id FROM WordList WHERE word = '%2$s'), " +
                            "'%1$s', " +
                            "'%2$s', " +
                            "%3$d)", word, relatedWord, value)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addRelationships(String word, ArrayList<String> relatedWords, ArrayList<Integer> values){
        for (int i = 0; i < relatedWords.size(); i++){
            DataBaseInteraction.addRelationship(word, relatedWords.get(i), values.get(i));
        }
    }

    public static void removeRelationship(String word, String relatedWord){
        try{
            conn.createStatement().execute(
                    String.format("DELETE FROM RelatedWords WHERE word = '%1$s' AND relatedWord = '%2$s'", word, relatedWord)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeRelationshipValue(String word, String relatedWord, Integer change){
        try{
            conn.createStatement().execute(
                    String.format("UPDATE RelatedWords SET value = value + %3$d WHERE word = '%1$s' AND relatedWord = '%2$s'", word, relatedWord, change)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}