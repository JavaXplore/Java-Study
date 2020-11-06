package com.practise.general;

import java.util.Scanner;

public class SeriesProblem {


    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            getSequence(a, b, n-1);
            System.out.print("\n");
        }
        in.close();
    }

    private static int getSequence(int a, int b, int n) {
        int sum = 0;
        if (n == 0) {
            System.out.print(a + b * (int) Math.pow(2, n) + " ");
            return a + b * (int) Math.pow(2, n);
        }

        sum = getSequence(a, b, n - 1);
        int calculatedValue = (b * ((int) Math.pow(2, n)));
        int value = sum + calculatedValue;
        System.out.print(value + " ");
        return value;


    }
}
