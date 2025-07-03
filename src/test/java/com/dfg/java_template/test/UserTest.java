package com.dfg.java_template.test;


import com.dfg.java_template.entity.Score;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserTest {
    
    public static void main(String[] args) {
        List<Score> scores = List.of(
                new Score("Alice", "Math", 90),
                new Score("Alice", "English", 85),
                new Score("Bob", "Math", 60),
                new Score("Bob", "English", 95),
                new Score("Charlie", "Math", 80),
                new Score("Charlie", "English", 100),
                new Score("Diana", "Math", 104),
                new Score("Diana", "English", 80)
        );
        
        scores.stream()
                .collect(Collectors.groupingBy(Score::getStudentName,
                        
                        ))
                
    }
}
