package com.eduplatform.behavioral.observer;

import java.util.ArrayList;
import java.util.List;


public class CourseSubject {
    private final String courseTitle;
    private final List<CourseObserver> observers = new ArrayList<>();

    public CourseSubject(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void subscribe(CourseObserver observer) { observers.add(observer); }
    public void unsubscribe(CourseObserver observer) { observers.remove(observer); }

    public void notifyAllObservers(String message) {
        for (CourseObserver observer : observers) {
            observer.onNotification(courseTitle, message);
        }
    }
}