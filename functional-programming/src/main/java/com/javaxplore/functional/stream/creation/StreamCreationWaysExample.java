package com.javaxplore.functional.stream.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationWaysExample {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        Stream<Integer> stream1 = integers.stream();
        System.out.println(stream1);
        //java.util.stream.ReferencePipeline$Head@d041cf
        // Here stream created is of wrapper class Integer.


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println(integerStream);
        //java.util.stream.ReferencePipeline$Head@1b0375b3
        // Here stream created is of wrapper class Integer.

        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        IntStream intStream = Arrays.stream(numberArray);
        System.out.println(intStream);
        //java.util.stream.IntPipeline$Head@2752f6e2
        // Here stream created is of int. Hence we get multiple methods that can ne directly on int.
        // Here we also don't have extra processing of Auto boxing and unboxing.


    }
}
