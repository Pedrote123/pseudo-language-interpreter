package textProcessing;

import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.rules.Rule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class TextCheck{
    /*
    partir
    filtrar con flag si el texto fue incorrecto o no;
    agrupar palabras repetidas;
    verificar si están añadidas las palabras;
    agregar las palabras junto a sus valores de relacion (plantear reglas luego);
     */
    public static void processText(String text){
        String[] separatedWords = text.split("[, .\\s]+");


        boolean isValid = true;
        ArrayList<String> filteredWords = new ArrayList<>();

        for (String word : separatedWords){
            if(!TextCheck.wordExists(word)){
                isValid = false;
            } else{
                filteredWords.add(word);
            }
        }

        if (!filteredWords.isEmpty()){
            TextCheck.updateWordList(filteredWords);

            if (isValid){
                //Placeholder, the logic to what happens when you introduce a text is yet to define
                TextCheck.getAnAnswer();
            }
        }


    }


    private static boolean wordExists(String word){
        JLanguageTool checker = new JLanguageTool(Languages.getLanguageForShortCode("en-US"));

        for (Rule rule : checker.getAllRules()){
            if (!rule.isDictionaryBasedSpellingRule()){
                checker.disableRule(rule.getId());
            }
        }

        try{
            return checker.check(word).isEmpty();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void updateWordList(ArrayList<String> filteredWords){
        ArrayList<String> filteredWordsWithoutDuplicates = new ArrayList<>(new LinkedHashSet<>(filteredWords));
        //Yet to define the logic on which the value of each word relationships are assigned
    }


    private static void getAnAnswer(){

    }
}