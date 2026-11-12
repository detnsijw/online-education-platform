package com.eduplatform.behavioral.strategy;

import com.eduplatform.creational.builder.Course;
import com.eduplatform.model.Student;

import java.util.List;

public class SkillBasedStrategy implements RecommendationStrategy {
    @Override
    public List<Course> recommend(Student student, List<Course> catalog) {
        return catalog.stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(student.getPreferredCategory()))
                .toList();
    }
}
