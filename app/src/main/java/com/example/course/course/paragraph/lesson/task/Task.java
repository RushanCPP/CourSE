package com.example.course.course.paragraph.lesson.task;

public abstract class Task {
    protected String text;
    protected int score;
    protected int maxScore;

    public Task(String text, int maxScore) {
        this.text = text;
        this.maxScore = maxScore;
        score = 0;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    // реализовать в наследниках с вариантами
    public String[] getVariants() {
        return null;
    }

    public abstract boolean answer(String answer);
}
