package exception;

public class PasswordValidationException extends RuntimeException {
    public PasswordValidationException(String letters) {
        super(letters);
    }

    public PasswordValidationException(){
        super();
    }
}
