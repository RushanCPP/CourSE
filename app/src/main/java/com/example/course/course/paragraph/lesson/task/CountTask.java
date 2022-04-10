package com.example.course.course.paragraph.lesson.task;

public class CountTask extends Task {
    Number[] numbers;
    String answer;

    public CountTask(String text, int maxScore, String number, Number... numbers) {
        super(text, maxScore);
        this.numbers = numbers;
        this.answer = number;
    }

    @Override
    public String getText() {
        return String.format(text, (Object[]) numbers);
    }

    @Override
    public boolean answer(String answer) {
        boolean accepted = answer.equals(this.answer);
        if (accepted) {
            score = maxScore;
        }
        return accepted;
    }
}
