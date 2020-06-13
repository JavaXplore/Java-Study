package com.javaxplore.functional.stream.custom;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByExample {
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

        //Group courses by category
        Map<String, List<Course>> groupedCourses = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory));
        System.out.println(groupedCourses);
        //Output:
        //DevOps=[Kubernetes:DevOps:200:91, Jenkins:DevOps:8000:94],
        // MicroServices=[API:MicroServices:1200:93, Microservices:MicroServices:12300:96],
        // Language=[Java:Language:20000:99, Python:Language:12000:95],
        // Cloud=[Docker:Cloud:2000:98, AWS:Cloud:10000:91],
        // Framework=[Spring:Framework:12000:97, Spring Boot:Framework:12000:92]}

        Map<String, Long> courseCountByCategory = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(courseCountByCategory);
        //{DevOps=2, MicroServices=2, Language=2, Cloud=2, Framework=2}

        Map<String, Optional<Course>> maxReviewScoreOfCourseByCategory = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore))));
        System.out.println(maxReviewScoreOfCourseByCategory);
        //{DevOps=Optional[Jenkins:DevOps:8000:94],
        // MicroServices=Optional[Microservices:MicroServices:12300:96],
        // Language=Optional[Java:Language:20000:99],
        // Cloud=Optional[Docker:Cloud:2000:98],
        // Framework=Optional[Spring:Framework:12000:97]}

        Map<String, List<String>> categoryCourseNameMap = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList())));
        System.out.println(categoryCourseNameMap);
        // {DevOps=[Kubernetes, Jenkins], MicroServices=[API, Microservices], Language=[Java, Python], Cloud=[Docker, AWS], Framework=[Spring, Spring Boot]}


    }
}
