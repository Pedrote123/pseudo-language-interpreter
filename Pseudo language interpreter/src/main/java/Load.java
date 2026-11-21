import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import config.Constants;
import database.DataBaseInitiation;

public class Load {

    public static void createBaseDocumentsIfDoesntExist(){
        if (!Load.baseExists()){
            Load.createBase();
        }
    }


    static Boolean baseExists(){
        if (!Files.exists(Constants.DATABASE_FOLDERPATH) && !Files.isDirectory(Constants.DATABASE_FOLDERPATH)){
            return false;
        }

        if (!Files.exists(Constants.DATABASE_PATH)){
            try {
                Files.deleteIfExists(Constants.DATABASE_FOLDERPATH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return false;
        }

        return true;
    }


    static void createBase(){
        try{
            Files.createDirectory(Constants.DATABASE_FOLDERPATH);
            DataBaseInitiation.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
