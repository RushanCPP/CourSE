package com.example.course.course;


import com.example.course.course.paragraph.Paragraph;

import java.util.ArrayList;

public class Course {
    protected String name;
    protected String author;
    protected int currentParagraph;
    protected ArrayList<Paragraph> paragraphs;
    protected int score;
    protected int maxScore;
    private String description;

    public Course(String name, String author, String description) {
        this.name = name;
        this.author = author;
        this.description = description;
        paragraphs = new ArrayList<>();
        maxScore = 0;
        currentParagraph = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean addParagraph(Paragraph paragraph) {
        maxScore += paragraph.getMaxScore();
        return paragraphs.add(paragraph);
    }

    public int getCurrentParagraph() {
        return currentParagraph;
    }

    public ArrayList<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public boolean answer(String answer) {
        boolean accepted = paragraphs.get(currentParagraph).answer(answer);
        if (accepted) {
            score = 0;
            for (Paragraph paragraph : paragraphs) {
                score += paragraph.getScore();
            }
            currentParagraph++;
        }
        return accepted;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
