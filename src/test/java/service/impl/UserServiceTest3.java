package service.impl;

import exception.PasswordValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest3 {

    @Test
    void isPasswordValid() {
        String validPassword = "12asAs!!";
        assertTrue(new UserService().isPasswordValid(validPassword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "aaaaaaaaa", "222222222222222"})
    public void isPasswordInValidParams(String invalidPassword) {
        assertFalse(new UserService().isPasswordValid(invalidPassword));
    }

    @Test
    void isPasswordInValid() {
        String validPassword = "12";
        assertFalse(new UserService().isPasswordValid(validPassword));
        validPassword = "aaaaaaaa";
        assertFalse(new UserService().isPasswordValid(validPassword));
    }


    //BADDDD
    @Test
    void validatePasswordBad() {
        String validPassword = "12_!AAaaghg";
        try {
            new UserService().validatePassword(validPassword);
        } catch (PasswordValidationException e) {
            fail();
        }
        assertTrue(true, validPassword + " is valid value for password");
    }

    @Test
    void validatePassword() {
        String inValidPassword = "12";
        PasswordValidationException thrown = assertThrows(PasswordValidationException.class, () -> {
            new UserService().validatePassword(inValidPassword);
        }, "Password validation error was expected");

        assertEquals("Length", thrown.getMessage());

    }

    @ParameterizedTest
    @CsvSource({"12,Length", "222222222222222,Letters", "yeueDfDD_@@,Digits"})
    public void isPasswordInValidParams2(String invalidPassword, String errorMessage) {
        PasswordValidationException thrown = assertThrows(PasswordValidationException.class, () -> {
            new UserService().validatePassword(invalidPassword);
        }, "Password validation error was expected");

        assertEquals(errorMessage, thrown.getMessage());
    }

    @Test
    public void test34(){
        String loginUser1 = "1";
        String password = "drwerewrwe";
        String expected = "1";
        String actial = UserService.getUserByLoginPassword(loginUser1, password);
        assertEquals(expected, actial);
    }
}