package com.javaxplore.functional.stream.custom;

import java.util.List;

public class Course {

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name + ":" + category + ":" + noOfStudents + ":" + reviewScore;
    }

    public static List<Course> getDefaultCourses(){
        return List.of(
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
    }
}
