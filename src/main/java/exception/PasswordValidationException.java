package exception;

public class PasswordValidationException extends Exception { 
    // try inherit from RuntimeException
    public PasswordValidationException(String letters) {
        super(letters);
    }

    public PasswordValidationException(){
        super();
    }
}
