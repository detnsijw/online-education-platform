package com.eduplatform.creational.factory;

class ArticleLesson implements LessonContent {
    private final String title;

    public ArticleLesson(String title) {
        this.title = title;
    }

    @Override
    public String render() {
        return "[Article] " + title + " (Markdown Read)";
    }
}
