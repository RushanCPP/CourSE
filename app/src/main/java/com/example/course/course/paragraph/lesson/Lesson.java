package com.example.course.course.paragraph.lesson;

import com.example.course.course.paragraph.lesson.task.Task;

import java.util.List;

public class Lesson {
    protected String name;
    protected Task task;

    public Lesson(String name, Task task) {
        this.name = name;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean answer(String answer) {
        boolean accepted = task.answer(answer);
        return accepted;
    }

    public int getScore() {
        return task.getScore();
    }

    public int getMaxScore() {
        return task.getMaxScore();
    }
}
