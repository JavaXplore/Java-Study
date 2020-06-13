package com.practise.general;


import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {

        Integer no = grades.get(0);
        Function<Integer, Integer> gradeFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer grade) {
                if(grade < 38){
                    return grade;
                }
                Integer nextMultiple =  findNextMultipleof5(grade);
                if ((nextMultiple - grade) < 3){
                    return nextMultiple;
                }else{
                    return grade;
                }
            }
        };
        List<Integer> finalGrades = grades.stream()
                .skip(0)
                .map(gradeFunction)
                .collect(toList());

        return finalGrades;
    }




    private static Integer findNextMultipleof5(int no) {
        int value = no / 5;
        value++;
        return value * 5;
    }

}

public class GradingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
