package com.eduplatform.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public interface CourseObserver {
    void onNotification(String courseTitle, String message);
}
