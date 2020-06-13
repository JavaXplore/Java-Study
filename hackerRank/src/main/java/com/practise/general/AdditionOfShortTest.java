package com.practise.general;

/**
 * Question: What will be output of the below give code?
 * Answer: We will get a compile time error at line 19
 * as "Non-static method 'add(int, int)' cannot be referenced from a static context"
 */
class Add {
    int add(int i, int j) {
        return i + j;
    }
}


public class AdditionOfShortTest extends Add {

    public static void main(String argv[]) {
        short s = 9;
        //System.out.println(add(s, 6));
    }
}
