package com.dfg.java_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score {
    private String studentName;
    private String subject;
    private int score;
}
