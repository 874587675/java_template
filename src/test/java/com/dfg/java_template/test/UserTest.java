package com.dfg.java_template.test;


import com.dfg.java_template.entity.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserTest {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 3, Arrays.asList(90, 80, 85)),
                new Student("Bob", 3, Arrays.asList(60, 75, 70)),
                new Student("Charlie", 4, Arrays.asList(88, 92, 91)),
                new Student("Diana", 4, Arrays.asList(55, 65, 60)),
                new Student("Eva", 3, Arrays.asList(100, 95, 98))
        );
        
        students.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list->
                                     list.stream().sorted(
                                            Comparator.comparing((Student student) -> student.getScores().get(0)).reversed())
                                            .limit(2)
                                            .map(Student::getName)
                                            .toList()
                                
                        )
                        ));
    }
}
