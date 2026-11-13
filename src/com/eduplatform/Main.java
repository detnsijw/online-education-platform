package com.eduplatform;

import com.eduplatform.behavioral.strategy.BudgetFriendlyStrategy;
import com.eduplatform.creational.builder.Course;
import com.eduplatform.creational.factory.LessonFactory;
import com.eduplatform.model.Student;
import com.eduplatform.structural.facade.EducationPlatformFacade;
import com.eduplatform.behavioral.strategy.SkillBasedStrategy;

public class Main {
    public static void main(String[] args) {
        EducationPlatformFacade platform = new EducationPlatformFacade(new SkillBasedStrategy());

        Course javaCourse = new Course.Builder("Design Patterns in Java")
                .category("Software Engineering")
                .basePrice(60.00)
                .addModule(LessonFactory.createLesson("VIDEO", "SOLID Principles"))
                .addModule(LessonFactory.createLesson("ARTICLE", "GoF Overview"))
                .addModule(LessonFactory.createLesson("QUIZ", "Pattern Identification"))
                .build();

        Course pythonCourse = new Course.Builder("Intro to Data Science")
                .category("Data Science")
                .basePrice(40.00)
                .addModule(LessonFactory.createLesson("VIDEO", "Pandas Basics"))
                .build();

        platform.publishCourse(javaCourse);
        platform.publishCourse(pythonCourse);
        System.out.println();

        Student alice = new Student("Alice", "Software Engineering");
        platform.showRecommendations(alice);

        platform.setRecommendationStrategy(new BudgetFriendlyStrategy());
        platform.showRecommendations(alice);
        System.out.println();

        platform.enrollStudent(alice, javaCourse, true, true);
        platform.gradeAssignment("Design Patterns in Java", "Assignment #1 graded: 98/100!");
    }
}