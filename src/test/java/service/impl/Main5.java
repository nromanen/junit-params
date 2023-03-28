package service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main5 {

    @Test
    public  void checkAnnotation() throws NoSuchMethodException {
        Class<?> suppressWarningsClass = CalculatorImplTest.class;
        System.out.printf("Is %s an annotation - %s", suppressWarningsClass, suppressWarningsClass.isAnnotation());
        System.out.println();
//
//        Class<?> arraysClass = Arrays.class;
//        System.out.printf("Is %s an annotation - %s", arraysClass, arraysClass.isAnnotation());
       Method m = suppressWarningsClass.getMethod("possitiveSum");
       assertTrue(m.isAnnotationPresent(MethodSource.class), "jjjj");

        for (Method method : suppressWarningsClass.getMethods())
            if( method.isAnnotationPresent(Test.class)){
                System.out.println("Yes");
            }

        assertTrue(true);


    }
}
