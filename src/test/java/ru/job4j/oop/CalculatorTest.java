package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void sum() {
        int result = Calculator.sum(7);
        int expected = 12;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void multiply() {
        int result = Calculator.multiply(4);
        int expected = 20;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void minus() {
        int result = Calculator.minus(4);
        int expected = -1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void divide() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(4);
        double expected = 0.8;
        assertThat(result).isEqualTo(expected, offset(0.1));
    }

    @Test
    void sumOfAll() {
        Calculator calculator = new Calculator();
        double result = calculator.sumOfAll(39);
        double expected = 280.8;
        assertThat(result).isCloseTo(expected, offset(0.1));
    }
}