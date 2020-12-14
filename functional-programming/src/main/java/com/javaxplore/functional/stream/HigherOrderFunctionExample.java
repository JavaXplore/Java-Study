package com.javaxplore.functional.stream;

import com.javaxplore.functional.stream.custom.Course;

import java.util.List;
import java.util.function.Predicate;

public class HigherOrderFunctionExample {
    //Functioin which returns a function in known as higher order functions.
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java", "Language", 99, 20000),
                new Course("Spring", "Framework", 97, 12000),
                new Course("Python", "Language", 95, 12000),
                new Course("Docker", "Cloud", 98, 2000),
                new Course("Spring Boot", "Framework", 92, 12000),
                new Course("API", "MicroServices", 93, 1200),
                new Course("Microservices", "MicroServices", 96, 12300),
                new Course("Kubernetes", "DevOps", 91, 200),
                new Course("Jenkins", "DevOps", 94, 8000),
                new Course("AWS", "Cloud", 91, 10000)
        );
        System.out.println("Original list: " + courses);

        Predicate<Course> reviewScoreLessThan90Predicate = getPredicateWithCutOffReviewScore(90);

        Predicate<Course> reviewScoreLessThan95Predicate = getPredicateWithCutOffReviewScore(95);

        //Predicates above holds a function retrurned from the method.

        System.out.println("Review score below 90" + reviewScoreLessThan90Predicate);

        System.out.println("Review score below 90" + reviewScoreLessThan95Predicate);


    }

    private static Predicate<Course> getPredicateWithCutOffReviewScore(int cutOffValue) {
        return course -> course.getReviewScore() < cutOffValue;
    }

}
