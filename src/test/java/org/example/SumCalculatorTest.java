package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {
    SumCalculator sumCalculator;



    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }
    @AfterEach
    void cleanUp(){
        sumCalculator = null;
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("getValidInputParam")
    void getValidInputParamTest(String name, int input, int expected) {
        int result = sumCalculator.sum(input);
        assertEquals(expected, result);
    }

    @Test
    void getIllegalArgumentTest(){
        assertThrows(IllegalArgumentException.class, () -> sumCalculator.sum(0));
    }


    public static Stream<Arguments> getValidInputParam() {
        return Stream.of(
                Arguments.of("Value 1:",1,1),
                Arguments.of("Value 3:",3,6)
        );
    }
}