package com.example.roomdatabasestudent;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasestudent.roomDatabase.MyViewModel;
import com.example.roomdatabasestudent.roomDatabase.adapters.SchoolAdapter;

import java.util.ArrayList;

public class SchoolActivity extends AppCompatActivity {

    RecyclerView rv_school;
    MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        rv_school=findViewById(R.id.rv_school);

        SchoolAdapter schoolAdapter = new SchoolAdapter(this,new ArrayList<>() );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_school.setLayoutManager(layoutManager);
        rv_school.setAdapter(schoolAdapter);

        // احصول على ViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getAllSchool().observe(this, schools -> {
            schoolAdapter.refreshDataSchool(schools);
        });

    }
}