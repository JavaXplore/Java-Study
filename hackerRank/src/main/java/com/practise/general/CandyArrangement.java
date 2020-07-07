package com.practise.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CandyArrangement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());

        List<List<Integer>> integerList = new ArrayList<>(count);
        for(int i=1; i<=count; i++){
            String input = s.nextLine();
            String[] split = input.split(" ");
            List<Integer> values = Arrays.stream(split).map(a -> Integer.parseInt(a)).collect(Collectors.toList());
            integerList.add(values);
        }

        integerList.stream().map(value -> {
            int totalCandy = value.get(0) + value.get(1);
            Integer k = value.get(2);
            if (k == 1) {
                return IntStream.rangeClosed(1, totalCandy).reduce(1, (a, b) -> a * b);
            } else {
                int kPermutation = IntStream.rangeClosed(1, k).reduce(1, (a, b) -> a * b);
                int countOfCandyArrangement = IntStream.rangeClosed(1, totalCandy).reduce(1, (a, b) -> a * b);
                return kPermutation * countOfCandyArrangement;
            }
        }).forEach(System.out::println);


    }


}
