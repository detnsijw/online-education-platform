package com.eduplatform.creational.factory;

class VideoLesson implements LessonContent {
    private final String title;

    public VideoLesson(String title) {
        this.title = title;
    }

    @Override
    public String render() {
        return "[Video] " + title + " (1080p Stream)";
    }
}
