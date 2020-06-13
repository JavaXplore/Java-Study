package com.javaxplore.functional.stream.creation;

import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {
        int sum = IntStream.range(1, 10).peek(System.out::println).sum(); //Here range doesn't includes the number given.
        System.out.println(sum);

        sum = IntStream.rangeClosed(1, 10).peek(System.out::println).sum(); //rangeClosed includes the value too. Hence 10 is considered
        System.out.println(sum);

        //Stream of int jump by 2
        sum = IntStream.iterate(1, i -> i + 2).limit(10).peek(System.out::println).sum(); //iterate gives us infinite stream, hence to limit it we need to limit it.
        System.out.println(sum);
        //Stream of squares of 2
        sum = IntStream.iterate(2, i -> i * 2).limit(10).peek(System.out::println).sum(); //iterate gives us infinite stream, hence to limit it we need to limit it.
        System.out.println(sum);
    }
}
