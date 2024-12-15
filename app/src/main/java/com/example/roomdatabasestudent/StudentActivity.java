package com.example.roomdatabasestudent;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasestudent.roomDatabase.MyViewModel;
import com.example.roomdatabasestudent.roomDatabase.adapters.SchoolAdapter;
import com.example.roomdatabasestudent.roomDatabase.adapters.StudentAdapter;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    RecyclerView rv_student;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        rv_student = findViewById(R.id.rv_student);

        StudentAdapter studentAdapter = new StudentAdapter(this, new ArrayList<>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_student.setLayoutManager(layoutManager);
        rv_student.setAdapter(studentAdapter);

        // احصول على ViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getAllStudent().observe(this, students -> {
            studentAdapter.refreshDataStudent(students);
        });
    }
}