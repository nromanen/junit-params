package service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import service.Calculator;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pass converted Message objects to our test method")
public class Test2 {

    @DisplayName("Should pass integer values as method parameters")
    @ParameterizedTest(name = "{index} => actual={0}/{1}, expected={2}")
    @CsvSource({
            "1, 2, 0.5",
            "12, -17, -0.70588",
    })
    void sumTest(@ConvertWith(IntegerConverter.class) int a,
                 @ConvertWith(IntegerConverter.class) int b,
                 @ConvertWith(DoubleConverter.class) double expected) {
        Calculator calc = new CalculatorImpl();
        double actual = calc.div(a, b);
        assertEquals(expected, actual, 0.001);
    }

    @ParameterizedTest
    @ValueSource(strings = {"header20,text20", "header30,text30"})
    public void messageTest(@ConvertWith(MessageConverter.class) Message message) {
        assertNotNull(message);
    }

    @ParameterizedTest
    @CsvSource({"header20,text20", "header30,text30"})
    public void messageTest2(@ConvertWith(MessageConverter.class) Message message) {
        assertNotNull(message);
    }

//    @ParameterizedTest
//    @CsvSource({"header20,text20", "header30,text30"})
//    public void messageTest2(String string) {
//        Message message = new Message(@ConvertWith(MessageConverter.class) string);
//        assertNotNull(message);
//    }

//    @ParameterizedTest
//    @ValueSource(@ConvertWith(MessageConverter.class) strings = {"header20,text20", "header30,text30"})
//    public void messageTest3(@ConvertWith(MessageConverter.class) Message message) {
//        assertNotNull(message);
//    }

}

class Message {
    private final String header;
    private final String description;

    public Message(String header, String description) {
        this.header = header;
        this.description = description;
    }
}

class MessageConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        String sourceString = (String) source;
        return new Message(sourceString.split(",")[0], sourceString.split(",")[1]);
    }

}
