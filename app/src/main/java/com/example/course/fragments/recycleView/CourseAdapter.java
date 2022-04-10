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
import com.example.course.course.Course;
import com.example.course.course.paragraph.Paragraph;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    public List<Paragraph> paragraphs;

    public CourseAdapter(List<Paragraph> paragraphList) {
        paragraphs = paragraphList;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_course_recycler_view_item, parent, false);
        Toast.makeText(parent.getContext(), paragraphs.size() + "", Toast.LENGTH_LONG).show();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Paragraph paragraph = paragraphs.get(position);
        holder.getNameTV().setText(paragraph.getName());
        holder.getScoreTV().setText(String.format("%d/%d", paragraph.getScore(), paragraph.getMaxScore()));
    }

    @Override
    public int getItemCount() {
        return paragraphs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTV, scoreTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.fragment_course_course_paragraph_name);
            scoreTV = itemView.findViewById(R.id.fragment_course_course_paragraph_score);
            Button goToButton = itemView.findViewById(R.id.fragment_course_course_paragraph_button);
            goToButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    MainActivity.paragraph = paragraphs.get(index);
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
