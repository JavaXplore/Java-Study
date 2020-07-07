package com.javaxplore.functional.stream;

import com.javaxplore.functional.stream.custom.Course;

import java.util.List;
import java.util.stream.Collectors;

public class StringOperationExample {
    public static void main(String[] args) {
        List<Course> courses = Course.getDefaultCourses();

        String collect = courses.stream()
                .map(s -> s.getName())
                .collect(Collectors.joining(" "));
        System.out.println(collect);


    }
}
