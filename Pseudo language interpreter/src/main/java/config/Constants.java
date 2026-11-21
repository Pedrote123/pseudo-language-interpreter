package config;
import java.nio.file.Path;

public class Constants{
    public static final String DATABASE_FOLDERSTRING = String.format("C:\\Users\\%s\\Documents\\pli", System.getProperty("user.name"));
    public static final Path DATABASE_FOLDERPATH = Path.of(DATABASE_FOLDERSTRING);

    public static final String DATABASE_PATHSTRING = String.format("C:\\Users\\%s\\Documents\\pli\\database.db", System.getProperty("user.name"));
    public static final Path DATABASE_PATH = Path.of(DATABASE_PATHSTRING);

    public static final String URL = String.format("jdbc:sqlite:%s", Constants.DATABASE_PATHSTRING);

    private Constants(){};
}