package com.eduplatform.creational.builder;

import com.eduplatform.creational.factory.LessonContent;
import com.eduplatform.model.CourseComponent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course implements CourseComponent {
    private final String title;
    private final String category;
    private final double basePrice;
    private final List<LessonContent> modules;

    private Course(Builder builder) {
        this.title = builder.title;
        this.category = builder.category;
        this.basePrice = builder.basePrice;
        this.modules = Collections.unmodifiableList(builder.modules);
    }

    @Override public String getTitle() { return title; }
    public String getCategory() { return category; }
    @Override public double getPrice() { return basePrice; }
    public List<LessonContent> getModules() { return modules; }

    @Override
    public String getDescription() {
        return title + " [" + category + "] (" + modules.size() + " modules)";
    }

    public static class Builder {
        private final String title;
        private String category = "General";
        private double basePrice = 49.99;
        private final List<LessonContent> modules = new ArrayList<>();

        public Builder(String title) { this.title = title; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder basePrice(double price) { this.basePrice = price; return this; }
        public Builder addModule(LessonContent lesson) { this.modules.add(lesson); return this; }
        public Course build() { return new Course(this); }
    }
}