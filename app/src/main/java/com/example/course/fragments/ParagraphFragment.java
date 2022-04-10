package com.example.course.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.course.MainActivity;
import com.example.course.R;

import java.util.Locale;

public class ParagraphFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paragraph, container, false);
        ((TextView) view.findViewById(R.id.fragment_paragraph_paragraph_name)).setText(MainActivity.paragraph.getName());
        ((TextView) view.findViewById(R.id.fragment_paragraph_paragraph_score))
                .setText(String.format(Locale.getDefault(),
                "%d/%d", MainActivity.paragraph.getScore(), MainActivity.paragraph.getMaxScore()));
        RecyclerView recyclerView = view.findViewById(R.id.fragment_paragraph_paragraph_lessons);
        recyclerView.setAdapter(null);
        return view;
    }
}