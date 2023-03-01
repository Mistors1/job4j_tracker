package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

 class FunctionCalculatorTest {
    @Test
     void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
     void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(2D, 5D, 10D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
     void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(3D, 5D, 9D);
        assertThat(result).isEqualTo(expected);
    }
}