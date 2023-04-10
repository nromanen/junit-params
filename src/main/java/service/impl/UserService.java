package service.impl;

import exception.PasswordValidationException;
import service.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    public boolean isPasswordValid(String password) {
        return true;
    }

    // qq1_  AAAAAAAA aaaaaaaaaa !!!! 11111
    public void validatePassword(String password) throws PasswordValidationException {
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
//            Pattern eightLength = Pattern.compile (".{8}");


        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        if (password.length() < 8) {
            throw new PasswordValidationException("Length");
        }

        if (!hasLetter.find()) {
            throw new PasswordValidationException("Letters");
        }

        if (!hasDigit.find()) {
            throw new PasswordValidationException("Digits");
        }
        if (!hasSpecial.find()) {
            throw new PasswordValidationException("Special");
        }
    }

    public static String getUserByLoginPassword(String login, String password){
        if (login == "1"){
            return null;
        }
        return login;
    }

}
