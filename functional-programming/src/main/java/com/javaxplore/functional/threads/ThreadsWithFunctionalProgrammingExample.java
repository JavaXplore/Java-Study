package com.javaxplore.functional.threads;

import java.util.TreeMap;
import java.util.stream.IntStream;

public class ThreadsWithFunctionalProgrammingExample {
    public static void main(String[] args) throws InterruptedException {

        //Traditional approach of creating Runnable template.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getId() + " : " + i);
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.start();
        Thread t3 = new Thread(runnable);
        t3.start();

        Thread.sleep(1000);

        System.out.println("*****************************************************");
        //Functional method approach for the above runnable.


        // Regular Funcrtional programming approach for runnable using loop

        Runnable runnable2 = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getId() + " : " + i);
            }
        };

        /*Runnable runnable2 = () -> {
            IntStream.range(0,10000)
                    .forEach( i -> System.out.println(Thread.currentThread().getId() +" : "+ i));
            };
        };*/


        Thread t4 = new Thread(runnable2);
        t4.start();
        Thread t5 = new Thread(runnable2);
        t5.start();
        Thread t6 = new Thread(runnable2);
        t5.start();
    }
}
