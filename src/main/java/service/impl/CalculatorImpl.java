package service.impl;

import exception.PasswordValidationException;
import service.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int a, int b) {

        return a + b;
    }

    @Override
    public int div(int a, int b) {
        if (b == 0){
            throw new IllegalArgumentException("Second argument cannot be zero");
        }
        return 0;
    }

    @Override
    public double logByBase(double base, double value) {
        if (base <= 0 || base == 1) {
            throw new IllegalArgumentException("Base " + base + " should be positive and not equals to 1");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("Value " + value + " should be more than zero");
        }
        return Math.log(value) / Math.log(base);
    }

}
