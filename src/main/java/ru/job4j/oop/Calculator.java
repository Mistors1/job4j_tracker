package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public double divide(int c) {
        return (double) c / x;
    }

    public double sumOfAll(int d) {
        return (double) minus(d) + divide(d) + sum(d) + multiply(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result = sum(10);
        int resultMulti = multiply(7);
        double resultDiv = calculator.divide(4);
        int resultMin = minus(8);
        double resultOfAll = calculator.sumOfAll(6);

        System.out.println(result);
        System.out.println(resultMulti);
        System.out.println(resultDiv);
        System.out.println(resultMin);
        System.out.println(resultOfAll);
    }
}
