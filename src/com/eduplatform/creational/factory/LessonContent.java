package com.eduplatform.creational.factory;

public interface LessonContent {
    String render();
}

class VideoLesson implements LessonContent {
    private final String title;
    public VideoLesson(String title) { this.title = title; }
    @Override public String render() { return "[Video] " + title + " (1080p Stream)"; }
}

class ArticleLesson implements LessonContent {
    private final String title;
    public ArticleLesson(String title) { this.title = title; }
    @Override public String render() { return "[Article] " + title + " (Markdown Read)"; }
}

class QuizLesson implements LessonContent {
    private final String title;
    public QuizLesson(String title) { this.title = title; }
    @Override public String render() { return "[Quiz] " + title + " (Auto-Graded)"; }
}