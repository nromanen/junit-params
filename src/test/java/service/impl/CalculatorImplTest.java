package service.impl;

import exception.PasswordValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import service.Calculator;

import java.util.Dictionary;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorImplTest {

    private static Calculator calc;

    @BeforeAll
    public static void beforeAll() {
        calc = new CalculatorImpl();
    }

    @ParameterizedTest(name = "Positive test for sum method")
    @MethodSource("provideSumTest")
    void sumTest(int a, int b, int output) {
        assertEquals(output, calc.sum(a, b));
    }

    private static Stream<Arguments> provideSumTest() {
        return Stream.of(Arguments.of(1, 2, -3));
    }

    @ParameterizedTest
    @MethodSource
    void sumTest2(int a, int b, int c) {
        assertEquals(c, calc.sum(a, b));
    }

    private static Stream<Arguments> sumTest2() {
        return Stream.of(Arguments.of(1, 2, 3));
    }

    @ParameterizedTest
    @CsvSource("negativeSumProvider")
    void sumTest3(String a, String b, String c) {
        assertEquals(Integer.parseInt(c), calc.sum(Integer.parseInt(a), Integer.parseInt(b)));
    }

    private static String negativeSumProvider() {
        return "a, b, c\n" +
                "1, 2, -3";
    }


    @ParameterizedTest
    @CsvSource({"1, 3, Base 1.0 should be positive and not equals to 1", "2, 1, mess", "2, -8, Value -8.0 should be more than zero"})
    void logTest(String a, String b, String output) {
        double first = Double.parseDouble(a);
        double second = Double.parseDouble(b);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.logByBase(first, second);
        }, "IllegalArgumentException was expected");

        assertEquals(output, thrown.getMessage());

    }


//    @ParameterizedTest
//    @MethodSource("negativePasswordProvider")
//    void negativePasswordTest(String password, String  errorMessage) {
//        calc.validatePassword(password);
//        PasswordValidationException thrown = Assertions.assertThrows(PasswordValidationException.class, () -> {
//            calc.validatePassword(password);
//        }, "PasswordValidationException was expected");
//
//        assertEquals(errorMessage, thrown.getMessage());
//    }
//
//    private static Stream<Arguments> negativePasswordProvider() {
//        return Stream.of(Arguments.of("1Aa_", "Password must contain at least 8 or more characters"),
//                Arguments.of("aaaaa_Aa", "Password must contain at least one digit"),
//                Arguments.of("1_678#47", "Password must  contain at least one letter"),
//                Arguments.of("12Aser569ihjlk", "Password must contain at least one special character"));
//    }

}