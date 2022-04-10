package com.example.course.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course.MainActivity;
import com.example.course.R;
import com.example.course.fragments.recycleView.CourseAdapter;
import com.example.course.fragments.recycleView.CoursesAdapter;

public class CourseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        ((TextView) view.findViewById(R.id.fragment_course_course_name)).setText(MainActivity.nowCourse.getName());
        ((TextView) view.findViewById(R.id.fragment_course_course_author)).setText(MainActivity.nowCourse.getAuthor());
        ((TextView) view.findViewById(R.id.fragment_course_course_description)).setText(MainActivity.nowCourse.getDescription());
        RecyclerView recyclerView = view.findViewById(R.id.fragment_course_course_paragraphs);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        CourseAdapter courseAdapter = new CourseAdapter(MainActivity.nowCourse.getParagraphs());
        recyclerView.setAdapter(courseAdapter);
        courseAdapter.setParagraphs(MainActivity.nowCourse.getParagraphs());
        return view;
    }
}