package UserDefinedException;

public class NotVaildAutosarFileException extends Exception {
    public NotVaildAutosarFileException() {
        super("The file is not a valid Autosar file.");
    }
    
}
