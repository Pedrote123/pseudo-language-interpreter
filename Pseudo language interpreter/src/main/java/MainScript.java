import database.DataBaseInteraction;
import textProcessing.TextCheck;

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
        //DataBaseInteraction.changeRelationshipValue("Ramon", "Ricardo", -3);

        TextCheck.processText("Hola buenos, dias");
        System.out.println("Hola");
    }
}