import java.io.File;
import java.nio.file.Path;

public class Load {

    public static void createBaseDocumentsIfDontExist(){
        if (!Load.baseExists()){
            Load.createBase();
        }
    }

    static Boolean baseExists() {
        /*
        Path folderPath = Path.get("");
        Boolean folderExists;

        Boolean dataBaseFileExists;
        return folderExists && dataBaseFileExists;

         */
        return false;
    }


    static void createBase(){}
}
