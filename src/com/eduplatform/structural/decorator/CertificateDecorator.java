package com.eduplatform.structural.decorator;

import com.eduplatform.model.CourseComponent;

public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(CourseComponent course) {
        super(course);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Verified Certificate";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 20.00;
    }
}
