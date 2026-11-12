package com.eduplatform.structural.facade;

import com.eduplatform.behavioral.observer.CourseSubject;
import com.eduplatform.behavioral.strategy.RecommendationStrategy;
import com.eduplatform.creational.builder.Course;
import com.eduplatform.model.CourseComponent;
import com.eduplatform.model.Student;
import com.eduplatform.structural.decorator.CertificateDecorator;
import com.eduplatform.structural.decorator.MentorSupportDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EducationPlatformFacade {
    private final List<Course> catalog = new ArrayList<>();
    private final Map<String, CourseSubject> notificationChannels = new HashMap<>();
    private RecommendationStrategy recommendationStrategy;

    public EducationPlatformFacade(RecommendationStrategy defaultStrategy) {
        this.recommendationStrategy = defaultStrategy;
    }

    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.recommendationStrategy = strategy;
    }

    public void publishCourse(Course course) {
        catalog.add(course);
        notificationChannels.put(course.getTitle(), new CourseSubject(course.getTitle()));
        System.out.println("Published: " + course.getDescription());
    }

    public CourseComponent enrollStudent(Student student, Course course, boolean withCert, boolean withMentor) {
        CourseComponent finalPackage = course;
        if (withCert) finalPackage = new CertificateDecorator(finalPackage);
        if (withMentor) finalPackage = new MentorSupportDecorator(finalPackage);

        CourseSubject subject = notificationChannels.get(course.getTitle());
        if (subject != null) {
            subject.subscribe(student);
        }

        System.out.printf("Enrolled %s in: %s | Total: $%.2f%n",
                student.getName(), finalPackage.getDescription(), finalPackage.getPrice());
        return finalPackage;
    }

    public void gradeAssignment(String courseTitle, String gradeUpdate) {
        CourseSubject subject = notificationChannels.get(courseTitle);
        if (subject != null) {
            subject.notifyAllObservers(gradeUpdate);
        }
    }

    public void showRecommendations(Student student) {
        System.out.println("Recommendations for " + student.getName() + ":");
        List<Course> results = recommendationStrategy.recommend(student, catalog);
        results.forEach(c -> System.out.println("  - " + c.getDescription() + " ($" + c.getPrice() + ")"));
    }
}