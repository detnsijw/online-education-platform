package com.eduplatform.behavioral.strategy;

import com.eduplatform.creational.builder.Course;
import com.eduplatform.model.Student;
import java.util.List;

public interface RecommendationStrategy {
    List<Course> recommend(Student student, List<Course> catalog);
}
