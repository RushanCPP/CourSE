package com.example.course.fragments.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.course.MainActivity;
import com.example.course.R;
import com.example.course.course.paragraph.Paragraph;
import com.example.course.course.paragraph.lesson.Lesson;

import java.util.List;

public class ParagraphAdapter extends RecyclerView.Adapter<ParagraphAdapter.ViewHolder> {
    public List<Lesson> lessons;
    public ParagraphAdapter() {
    }
    public ParagraphAdapter(List<Lesson> lessonList) {
        lessons = lessonList;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_paragraph, parent, false);
        Toast.makeText(parent.getContext(), lessons.size() + "", Toast.LENGTH_LONG).show();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        holder.getNameTV().setText(lesson.getName());
        holder.getScoreTV().setText(String.format("%d/%d", lesson.getScore(), lesson.getMaxScore()));
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTV, scoreTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.fragment_paragraph_paragraph_name);
            scoreTV = itemView.findViewById(R.id.fragment_paragraph_paragraph_score);
            Button goToButton = itemView.findViewById(R.id.fragment_paragraph_go_to_lesson);
            goToButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    MainActivity.lesson = lessons.get(index);
                    Navigation.findNavController(view).navigate(R.id.action_courseFragment_to_paragraphFragment);
                }
            });
        }

        public TextView getNameTV() {
            return nameTV;
        }

        public TextView getScoreTV() {
            return scoreTV;
        }
    }
}
