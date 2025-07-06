package com.dfg.java_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;       // 姓名
    private int grade;         // 年级（1~6）
    private List<Integer> scores; // 各科成绩，长度固定为3：语文、数学、英语
    
}
