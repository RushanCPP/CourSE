package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.course.course.Course;
import com.example.course.course.paragraph.Paragraph;

public class MainActivity extends AppCompatActivity {
    public static Course nowCourse = null;
    public static Paragraph paragraph = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}