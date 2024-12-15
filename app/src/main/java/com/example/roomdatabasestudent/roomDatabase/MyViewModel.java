package com.example.roomdatabasestudent.roomDatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatabasestudent.roomDatabase.entity.School;
import com.example.roomdatabasestudent.roomDatabase.entity.Student;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MyRepository myRepository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        myRepository = new MyRepository(application);
    }

    public void insertSchool(School school) {
        myRepository.insertSchool(school);
    }

    public void updateSchool(School school) {
        myRepository.updateSchool(school);
    }

    public void deleteSchool(School school) {
        myRepository.deleteSchool(school);
    }

    public LiveData<List<School>> getAllSchool() {
        return myRepository.getAllSchool();
    }

    public LiveData<List<School>> getAllBySchoolId(int id) {
        return myRepository.getAllBySchoolId(id);
    }

    public void insertStudent(Student student) {
        myRepository.insertStudent(student);
    }

    public void updateStudent(Student student) {
        myRepository.updateStudent(student);
    }

    public void deleteStudent(Student student) {
        myRepository.deleteStudent(student);
    }

    public LiveData<List<Student>> getAllStudent() {
        return myRepository.getAllStudent();
    }

    public LiveData<List<Student>> getAllByStudent(int id) {
        return myRepository.getAllByStudent(id);
    }

}
