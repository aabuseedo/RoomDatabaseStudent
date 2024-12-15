package com.example.roomdatabasestudent.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatabasestudent.roomDatabase.dao.SchoolDao;
import com.example.roomdatabasestudent.roomDatabase.dao.StudentDao;
import com.example.roomdatabasestudent.roomDatabase.entity.School;
import com.example.roomdatabasestudent.roomDatabase.entity.Student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class, School.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract SchoolDao schoolDao();

    public abstract StudentDao studentDao();

    public static volatile MyDatabase INSTANCE;

    public static final int NUMBER_OF_THREADS = 4;
    public static ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static MyDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyDatabase.class, "my_database")
                            .addCallback(roomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                SchoolDao schoolDao = INSTANCE.schoolDao();

                School school = new School(40, "Gaza School");
                schoolDao.insertSchool(school);
                School school2 = new School(50, "Palestine School");
                schoolDao.insertSchool(school2);
                School school3 = new School(60, "Ahmed School");
                schoolDao.insertSchool(school3);
                School school4 = new School(70, "Mohammed School");
                schoolDao.insertSchool(school4);
                School school5 = new School(80, "Mahmod School");
                schoolDao.insertSchool(school5);
                School school6 = new School(90, "kamel School");
                schoolDao.insertSchool(school6);

                //StudentDao studentDao = INSTANCE.studentDao();
                //Student student = new Student("Ali","First", )




            });
        }
    };

}
