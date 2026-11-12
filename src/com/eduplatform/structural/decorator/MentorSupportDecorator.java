package com.eduplatform.structural.decorator;

import com.eduplatform.model.CourseComponent;

public class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(CourseComponent course) {
        super(course);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 1-on-1 Mentor Support";
    }
    @Override
    public double getPrice() {
        return super.getPrice() + 35.00;
    }
}
