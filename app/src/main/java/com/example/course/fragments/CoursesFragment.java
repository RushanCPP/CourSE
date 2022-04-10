package com.example.course.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.course.R;
import com.example.course.course.Course;
import com.example.course.course.paragraph.Paragraph;
import com.example.course.course.paragraph.lesson.Lesson;
import com.example.course.course.paragraph.lesson.task.StudyTask;
import com.example.course.fragments.recycleView.CoursesAdapter;

import java.util.ArrayList;
import java.util.List;

public class CoursesFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    // TODO: add Retrofit
    public List<Course> getCourses() {
        Course course = new Course("Математика", "Ю.Н.Миндюк",
                "Этот курс вас познакомит с основами алгебры 9 класса");
        Paragraph paragraph = new Paragraph("Квадратичная функция");
        paragraph.addLesson(new Lesson("Функция", new StudyTask("Функция f(x) = зависимость", 5)));
        paragraph.addLesson(new Lesson("Свойства функций", new StudyTask("y = f(x)",5)));
        course.addParagraph(paragraph);
        paragraph = new Paragraph("Вероятность");
        paragraph.addLesson(new Lesson("Вероятности", new StudyTask("Веротность P(A) - вероятность события А", 5)));
        paragraph.addLesson(new Lesson("P(A)", new StudyTask("P(A) = N(A)/N", 10)));
        course.addParagraph(paragraph);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        return courses;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_courses_recycler_view_item_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(new CoursesAdapter(getCourses()));
        return view;
    }
}