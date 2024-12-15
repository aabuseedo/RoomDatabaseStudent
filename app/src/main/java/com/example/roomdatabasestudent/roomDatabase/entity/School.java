package com.example.roomdatabasestudent.roomDatabase.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "school_table")
public class School {

    @ColumnInfo(name = "idSchool")
    @PrimaryKey(autoGenerate = true)
    private int idSchool;
    @ColumnInfo(name = "nameSchool")
    private String nameSchool;
    @ColumnInfo(name = "StudentNo")
    private int StudentNo;

    public School() {
    }

    public School(int studentNo, String nameSchool) {
        this.StudentNo = studentNo;
        this.nameSchool = nameSchool;
    }

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public int getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(int studentNo) {
        StudentNo = studentNo;
    }
}
