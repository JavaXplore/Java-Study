package com.javaxplore.functional.stream;

import com.javaxplore.functional.stream.custom.Course;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<Course> courses = Course.getDefaultCourses();
        System.out.println(courses);

        //Lets get stream of characters of course name.
        List<String[]> collect = courses.stream()
                .map(course -> course.getName()).map(s -> s.split("")).collect(Collectors.toList());

        /**
         * In above code we realised that we are getting List of string array instead of steam of characters.
         * Thus we realised that before collecting it to a list it is a stream of stream.
         */
        System.out.println(collect);

        /**To achieve the stream of characters we can used FlatMap method of streams. Thus this method helps us to
         * get a single stream from stream of streams.
         * FlatMap is used to flatten the stream. Ex: If we have a stream of stream then flatMap
         *  is used to create a single stream.
         */
        List<String> flatMapCollect = courses.stream()
                .map(course -> course.getName())
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(flatMapCollect);
    }
}
