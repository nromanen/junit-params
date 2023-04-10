package exception;

public class PasswordValidationException extends Exception { // from RuntimeException
    public PasswordValidationException(String letters) {
        super(letters);
    }

    public PasswordValidationException(){
        super();
    }
}
