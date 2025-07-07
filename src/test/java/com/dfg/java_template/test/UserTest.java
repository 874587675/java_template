package com.dfg.java_template.test;


import com.dfg.java_template.entity.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserTest {

    public static void main(String[] args) {
        List<String> subjects = Arrays.asList("语文", "数学", "英语");


        List<Student> students = Arrays.asList(
                new Student("Alice", 3, Arrays.asList(90, 80, 85)),
                new Student("Bob", 3, Arrays.asList(60, 75, 70)),
                new Student("Charlie", 4, Arrays.asList(88, 92, 91)),
                new Student("Diana", 4, Arrays.asList(55, 65, 60)),
                new Student("Eva", 3, Arrays.asList(100, 95, 98))
        );


        students.stream()
                .flatMap(student -> 
                        IntStream.range(0,3).mapToObj(i-> new AbstractMap.SimpleEntry<Integer, Map.Entry<String, Map.Entry<String, Integer>>>(
                                student.getGrade(),new AbstractMap.SimpleEntry<>(subjects.get(i),new AbstractMap.SimpleEntry<>(student.getName(),student.getScores().get(i)))
                        )))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.groupingBy(e->e.getValue().getKey(),
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(e->e.getValue().getValue().getValue())),
                                        optional -> optional.get().getValue().getValue()
                                )
                                )));
                
    }
}
