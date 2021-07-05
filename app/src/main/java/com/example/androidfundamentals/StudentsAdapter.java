package com.example.androidfundamentals;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {
    private static final String TAG = StudentsAdapter.class.getSimpleName();
    private List<DataSource.Student> studentList;

    StudentsAdapter(List<DataSource.Student> studentList){
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentsAdapter.StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerView = layoutInflater.inflate(R.layout.item_student, parent, false );

        return new StudentsAdapter.StudentsViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.StudentsViewHolder holder, int position) {
        String firstName = studentList.get(position).getFirstName();
        String lastName = studentList.get(position).getLastName();
        holder.fName.setText(firstName);
        holder.lName.setText(lastName);

        holder.fName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "POSITION CLICK: text= " + firstName + " position " + lastName);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentsViewHolder extends RecyclerView.ViewHolder{
        TextView fName;
        TextView lName;

        public StudentsViewHolder(View itemView) {
            super(itemView);
            fName = itemView.findViewById(R.id.tvFirstName);
            lName = itemView.findViewById(R.id.tvLastName);
        }
    }
}
