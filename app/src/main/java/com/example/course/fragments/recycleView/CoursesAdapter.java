package com.example.course.fragments.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.course.MainActivity;
import com.example.course.R;
import com.example.course.course.Course;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {
    public List<Course> courses;

    public CoursesAdapter(List<Course> courseList) {
        courses = courseList;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_courses_recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.getNameTV().setText(course.getName());
        holder.getAuthorTV().setText(course.getAuthor());
        holder.getDescriptionTV().setText(course.getDescription());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTV, authorTV, descriptionTV;
        private final Button goToButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.fragment_courses_recycler_view_item_course_name);
            authorTV = itemView.findViewById(R.id.fragment_courses_recycler_view_item_course_author);
            descriptionTV = itemView.findViewById(R.id.fragment_courses_recycler_view_item_course_description);
            goToButton = itemView.findViewById(R.id.fragment_courses_recycler_view_item_go_to_course);
            goToButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    MainActivity.nowCourse = courses.get(index);
                    Navigation.findNavController(view).navigate(R.id.action_coursesFragment_to_courseFragment);
                }
            });
        }

        public TextView getNameTV() {
            return nameTV;
        }

        public TextView getAuthorTV() {
            return authorTV;
        }

        public TextView getDescriptionTV() {
            return descriptionTV;
        }
    }
}
