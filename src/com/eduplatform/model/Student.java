package com.eduplatform.model;

import com.eduplatform.behavioral.observer.CourseObserver;

public class Student implements CourseObserver {
    private final String name;
    private final String preferredCategory;

    public Student(String name, String preferredCategory) {
        this.name = name;
        this.preferredCategory = preferredCategory;
    }

    public String getName() { return name; }
    public String getPreferredCategory() { return preferredCategory; }

    @Override
    public void onNotification(String courseTitle, String message) {
        System.out.println("  [Notification -> " + name + "] " + courseTitle + ": " + message);
    }
}