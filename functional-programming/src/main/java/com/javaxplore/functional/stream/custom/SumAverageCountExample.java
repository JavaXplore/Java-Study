package com.javaxplore.functional.stream.custom;

import java.util.List;
import java.util.OptionalDouble;

public class SumAverageCountExample {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java", "Language", 99, 20000),
                new Course("Spring", "Framework", 97, 12000),
                new Course("Spring Boot", "Framework", 92, 12000),
                new Course("Python", "Language", 95, 12000),
                new Course("API", "MicroServices", 93, 1200),
                new Course("Microservices", "MicroServices", 96, 12300),
                new Course("Docker", "Cloud", 98, 2000),
                new Course("Kubernetes", "DevOps", 91, 200),
                new Course("Jenkins", "DevOps", 94, 8000),
                new Course("AWS", "Cloud", 91, 10000)
        );
        //Sum method of Streams
        int sum = courses.stream()
                .mapToInt(Course::getNoOfStudents)
                .sum();

        System.out.println("Total students for courses are : " + sum);

        //Average method of Streams

        OptionalDouble average = courses.stream()
                .mapToInt(Course::getReviewScore)
                .average();

        System.out.println("Average review score for courses is : " + average.getAsDouble());

        //Count method of Streams

        long count = courses.stream().count();

        System.out.println("Total number of courses are: " + count);


    }



}
