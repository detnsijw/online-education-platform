package com.eduplatform.structural.decorator;

import com.eduplatform.model.CourseComponent;

public abstract class CourseDecorator implements CourseComponent {
    protected final CourseComponent wrappedCourse;

    public CourseDecorator(CourseComponent wrappedCourse) {
        this.wrappedCourse = wrappedCourse;
    }

    @Override
    public String getTitle() {
        return wrappedCourse.getTitle();
    }
    @Override
    public String getDescription() {
        return wrappedCourse.getDescription();
    }
    @Override
    public double getPrice() {
        return wrappedCourse.getPrice();
    }
}

