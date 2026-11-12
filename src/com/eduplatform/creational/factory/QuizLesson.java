package com.eduplatform.creational.factory;

class QuizLesson implements LessonContent {
    private final String title;

    public QuizLesson(String title) {
        this.title = title;
    }

    @Override
    public String render() {
        return "[Quiz] " + title + " (Auto-Graded)";
    }
}
