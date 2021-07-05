package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivityComplexViews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_complex_views);

        DataSource dataSource = new DataSource();
        List<DataSource.Student> studentList = dataSource.getStudents();

        RecyclerView studentListRecycler = findViewById(R.id.rvStudentList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        studentListRecycler.setLayoutManager(linearLayoutManager);

        StudentsAdapter studentsAdapter = new StudentsAdapter(studentList);
        studentListRecycler.setAdapter(studentsAdapter);
    }
}