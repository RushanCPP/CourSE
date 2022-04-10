package com.example.course.course.paragraph;

import com.example.course.course.paragraph.lesson.Lesson;

import java.util.ArrayList;

public class Paragraph {
    protected String name;
    protected ArrayList<Lesson> lessons;
    protected int currentLesson = 0;
    protected int score = 0;
    protected int maxScore = 0;

    public Paragraph(String name) {
        this.name = name;
        lessons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public int getCurrentLesson() {
        return currentLesson;
    }

    public void setCurrentLesson(int currentLesson) {
        this.currentLesson = currentLesson;
    }

    public boolean answer(String answer) {
        boolean accepted = lessons.get(currentLesson).answer(answer);
        if (accepted) {
            this.score = 0;
            for (Lesson lesson : lessons) {
                score += lesson.getScore();
            }
            currentLesson++;
        }
        return accepted;
    }

    public boolean addLesson(Lesson lesson) {
        maxScore += lesson.getMaxScore();
        return lessons.add(lesson);
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }
}
