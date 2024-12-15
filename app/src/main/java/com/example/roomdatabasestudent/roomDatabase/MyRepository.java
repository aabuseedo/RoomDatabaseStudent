package com.example.roomdatabasestudent.roomDatabase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomdatabasestudent.roomDatabase.dao.SchoolDao;
import com.example.roomdatabasestudent.roomDatabase.dao.StudentDao;
import com.example.roomdatabasestudent.roomDatabase.entity.School;
import com.example.roomdatabasestudent.roomDatabase.entity.Student;

import java.util.List;

public class MyRepository {

    private SchoolDao schoolDao;
    private StudentDao studentDao;

    MyRepository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        schoolDao = db.schoolDao();
        studentDao = db.studentDao();
    }

    void insertSchool(School school) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            schoolDao.insertSchool(school);
        });
    }

    void updateSchool(School school) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            schoolDao.updateSchool(school);
        });
    }

    void deleteSchool(School school) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            schoolDao.deleteSchool(school);
        });
    }

    LiveData<List<School>> getAllSchool() {
        return schoolDao.getAllSchool();
    }

    LiveData<List<School>> getAllBySchoolId(int id) {
        return schoolDao.getAllBySchoolId(id);
    }

    void insertStudent(Student student) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            studentDao.insertStudent(student);
        });
    }

    void updateStudent(Student student) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            studentDao.updateStudent(student);
        });
    }

    void deleteStudent(Student student) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            studentDao.deleteStudent(student);
        });
    }

    LiveData<List<Student>> getAllStudent() {
        return studentDao.getAllStudent();
    }

    LiveData<List<Student>> getAllByStudent(int id) {
        return studentDao.getAllByStudent(id);
    }

}
