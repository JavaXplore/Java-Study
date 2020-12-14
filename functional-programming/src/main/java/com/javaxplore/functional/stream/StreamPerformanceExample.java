package com.javaxplore.functional.stream;

import com.javaxplore.functional.stream.custom.Course;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPerformanceExample {
    public static void main(String[] args) {
        List<Course> courses = Course.getDefaultCourses();

        courses.stream().forEach(System.out::println);

        List<String> courseNames = courses.stream().map(c -> c.getName()).collect(Collectors.toList());
        System.out.println("**********************************************************************\n\n");


        //Find the first course whose length is greater than 10 and upparcase it.

        Optional<String> firstCourse = courseNames.stream().filter(course -> course.length() > 11).map(String::toUpperCase).findFirst();

        if (firstCourse.isPresent()) {
            System.out.println(firstCourse.get());
        }

        System.out.println("**********************************************************************\n\n");

        //Understanding how streams works

        //Peek is added after stream() so that all the values are printed and second peek will execute if filter gets executed.
        // As we want only first element, if the required element is found then stream stops executing and no further elements are scanned.
        // Hence when the first element is found no further elements are checked.
        //** Peek only gets the element and doesnt removes it.

        firstCourse = courseNames.stream().peek(System.out::println)
                .filter(course -> course.length() > 11)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();

        // Output of above code is:
        // Java
        // Spring
        // Spring Boot
        // Python
        // API
        // Microservices
        // MICROSERVICES

        System.out.println("**********************************************************************\n\n");

        // All the intermediate operations in stream operates on stream and return back stream. These operations are
        // lazy and is not executed immediately. These intermediate operations are executed only when the termincal operation
        // is seen.

        // We removed the terminal operation i.e. findFirst() to check the lazy execution of intermediate operations.
        Stream<String> peek = courseNames.stream().peek(System.out::println)
                .filter(course -> course.length() > 11)
                .map(String::toUpperCase)
                .peek(System.out::println);

        System.out.println("Code executed for lazy execution section.");

        //Output of above code is as below. The intermediate operations didnt get executed when we removed the terminal
        // operation.

        // **********************************************************************
        // Code executed for lazy execution section.

        System.out.println("**********************************************************************\n\n");

        // Now when we execute a terminal operation on the resulted stream then the code gets executed.

        peek.findFirst();

        // Output of above code
        // Java
        // Spring
        // Spring Boot
        // Python
        // API
        // Microservices
        // MICROSERVICES






    }
}
