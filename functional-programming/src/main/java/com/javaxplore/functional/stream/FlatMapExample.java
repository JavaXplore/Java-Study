package com.javaxplore.functional.stream;

import com.javaxplore.functional.stream.custom.Course;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {

        List<Course> coursesList = Course.getDefaultCourses();
        List<String> courses = coursesList.stream().map(c -> c.getName()).collect(Collectors.toList());

        courses.stream().forEach(System.out::println);

        //convert list to single String with comma seperated values.

        String singleString = courses.stream().collect(Collectors.joining(","));

        System.out.println(singleString);


        //Print all the charactes of words in the list.

        List charWiseCourses = courses.stream().map(c -> c.split("")).collect(Collectors.toList()); //This will be returning array of string instead of charactes which is expected.
        charWiseCourses.forEach(System.out::println);

        // To flaten the structure and get the list of char of all the workds in list we use flatMap

        courses.stream().map(c -> c.split("")).flatMap(Arrays::stream).forEach(System.out::println);

        System.out.println("*********************************************");

        //Get all the distinct characters in the list.

        courses.stream().map(c -> c.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        System.out.println("*********************************************");

        //Find the tuples from the courses list where length of course is same. Below is the expected output.
        //[Spring, Python]
        //[Spring, Docker]
        //[Python, Spring]
        //[Python, Docker]
        //[API, AWS]
        //[Docker, Spring]
        //[Docker, Python]
        //[AWS, API]

        List<Course> course2List = Course.getDefaultCourses();
        List<String> courses2 = course2List.stream().map(course -> course.getName()).collect(Collectors.toList());
        courses.stream()
                .flatMap(course -> courses2.stream()
                        .filter(course2 -> course2.length() == course.length())
                        .map(course2 -> List.of(course, course2)))
                .filter(list -> list.get(0) != list.get(1)).forEach(System.out::println);


    }
}
