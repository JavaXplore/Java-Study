package com.javaxplore.functional.stream.creation;

import java.util.stream.IntStream;

public class StreamCreationExample {
    public static void main(String[] args) {
        IntStream rangeStream = IntStream.range(1, 10); //range method gives us a stream of provided values where 10 is not included. As we are using IntStream the values are primitive.
        System.out.println("Range method example:");
        rangeStream.forEach(System.out::println);

        IntStream rangeClosed = IntStream.rangeClosed(1, 10); //rangeClosed works similar to range but the 10 value is included.
        System.out.println("RangeClosed method example:");
        rangeClosed.forEach(System.out::println);

        IntStream iterateStream = IntStream.iterate(1, e -> e + 2).limit(10); //To generate stream we can use iterate method which helps to provide our own logic to generate the stream. Here we are adding 2 in the number.
        System.out.println("Iterate method example:");
        iterateStream.forEach(System.out::println);

        iterateStream = IntStream.iterate(1, e -> e + 2).limit(10);
        System.out.println("Peek method example:");
        int sum = iterateStream.peek(System.out::println).sum();
        System.out.println(sum);


    }
}
