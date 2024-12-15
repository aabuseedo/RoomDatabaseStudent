package com.example.roomdatabasestudent.roomDatabase.entity;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.roomdatabasestudent.Converter;

import java.util.Date;


@Entity(tableName = "student_table" ,
        foreignKeys = @ForeignKey(entity = School.class, parentColumns = {"idSchool"},
        childColumns = {"id"}))
@TypeConverters(Converter.class)
public class Student {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "level")
    private String level;
    @ColumnInfo(name = "photo")
    private Bitmap photo;
    @ColumnInfo(name = "birthDate")
    private Date birthDate;
    @ColumnInfo(name = "idSchool")
    private int idSchool;

    @Ignore
    public Student(String name, String level, Bitmap photo, Date birthDate) {
        this.name = name;
        this.level = level;
        this.photo = photo;
        this.birthDate = birthDate;
    }
    public Student(String name, String level, Bitmap photo, Date birthDate, int idSchool) {
        this.name = name;
        this.level = level;
        this.photo = photo;
        this.birthDate = birthDate;
        this.idSchool = idSchool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }
}
