import database.DataBaseInteraction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class MainScript{
    public static void main(String[] args) {
        Load.createBaseDocumentsIfDoesntExist();

        //DataBaseInteraction.addWord("Ramon");
        //DataBaseInteraction.addWords(new ArrayList<String>(Arrays.asList("Jose", "Ricardo", "Ramiro")));

        //DataBaseInteraction.addRelationship("Ramon", "Jose", 5);
        //DataBaseInteraction.removeRelationship("Ramon", "Jose");
        DataBaseInteraction.changeRelationshipValue("Ramon", "Ricardo", -3);
        System.out.println("Hola");
    }
}