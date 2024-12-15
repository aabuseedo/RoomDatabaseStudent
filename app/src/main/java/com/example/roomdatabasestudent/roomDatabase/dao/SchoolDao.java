package com.example.roomdatabasestudent.roomDatabase.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabasestudent.roomDatabase.entity.School;

import java.util.List;

@Dao
public interface SchoolDao {

    @Insert
    void insertSchool (School school);
    @Update
    void updateSchool (School school);
    @Delete
    void deleteSchool (School school);

    //لعرض المدارس
    @Query("SELECT * FROM SCHOOL_TABLE")
    LiveData<List<School>> getAllSchool();

    // بدي اعرض كل الطلاب الموجودين بالمدرسة بواسطة المفتاج  الاجنبي
    @Query("SELECT * FROM SCHOOL_TABLE WHERE idSchool  = :id ")
    LiveData <List<School>>getAllBySchoolId(int id);


}
