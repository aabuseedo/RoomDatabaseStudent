package com.example.roomdatabasestudent.roomDatabase.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabasestudent.roomDatabase.entity.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    //لعرض كل الطلاب
    @Query("SELECT * FROM  student_table ")
    LiveData<List<Student>> getAllStudent();

    // لعرض الطلاب في مدرسة معينة
    @Query("SELECT * FROM student_table WHERE id  = :id ")
    LiveData<List<Student>> getAllByStudent(int id);
}
