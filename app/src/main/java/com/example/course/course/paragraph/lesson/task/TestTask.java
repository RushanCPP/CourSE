package com.example.course.course.paragraph.lesson.task;

public class TestTask extends Task {
    String[] variants;
    int answerIndex;

    public TestTask(String text, int maxScore, int answerIndex, String[] variants) {
        super(text, maxScore);
        this.answerIndex = answerIndex;
        this.variants = variants;
    }


    @Override
    public boolean answer(String answer) {
        boolean accepted = answer.toString().equals(variants[answerIndex]);
        if (accepted) {
            score = maxScore;
        }
        return accepted;
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public String[] getVariants() {
        return variants;
    }
}
