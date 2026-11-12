package com.eduplatform.creational.factory;

public class LessonFactory {
    public static LessonContent createLesson(String type, String title) {
        return switch (type.toUpperCase()) {
            case "VIDEO" -> new VideoLesson(title);
            case "ARTICLE" -> new ArticleLesson(title);
            case "QUIZ" -> new QuizLesson(title);
            default -> throw new IllegalArgumentException("Unknown lesson type: " + type);
        };
    }
}
