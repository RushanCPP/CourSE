package com.example.course.course.paragraph.lesson.task;

public class StudyTask extends Task {
    public StudyTask(String text, int score) {
        super(text, score);
    }

    @Override
    public boolean answer(String answer) {
        score = maxScore;
        return true;
    }
}
