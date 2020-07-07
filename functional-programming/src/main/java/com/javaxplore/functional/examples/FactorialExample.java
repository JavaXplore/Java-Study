package com.javaxplore.functional.examples;

import java.util.stream.LongStream;

public class FactorialExample {
    private long factorialUsingStream;

    public static void main(String[] args) {
        int value = 5;
        Long factorial = getFactorialUsingTraditionalWay(value);

        System.out.println("Factorial of " + value + " using traditional method is :" + factorial);

        long factorialUsingStream = LongStream.rangeClosed(1, value).reduce(1, (x, y) -> x * y);
        System.out.println("Factorial of " + value + " using steams is :" + factorialUsingStream);
    }

    private static Long getFactorialUsingTraditionalWay(final int value) {
        if (value == 1) {
            return 1L;
        } else {
            return value * getFactorialUsingTraditionalWay(value - 1);
        }
    }
}
