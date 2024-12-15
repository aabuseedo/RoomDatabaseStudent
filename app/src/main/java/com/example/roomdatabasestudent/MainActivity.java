package com.example.roomdatabasestudent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasestudent.roomDatabase.MyViewModel;
import com.example.roomdatabasestudent.roomDatabase.entity.Student;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn_photoStudent, btn_addStudent, btn_viewSchool, btn_viewStudent;
    EditText et_nameStudent, et_levelStudent, et_dateStudent;
    Spinner sp_school;

    ImageView imageView;
    MyViewModel myViewModel;

    Bitmap bitmapPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_viewSchool = findViewById(R.id.btn_viewSchool);
        btn_viewStudent = findViewById(R.id.btn_viewStudent);
        btn_addStudent = findViewById(R.id.btn_addStudent);
        btn_photoStudent = findViewById(R.id.btn_photoStudent);

        et_nameStudent = findViewById(R.id.et_nameStudent);
        et_levelStudent = findViewById(R.id.et_levelStudent);
        et_dateStudent = findViewById(R.id.et_dateStudent);

        sp_school = findViewById(R.id.sp_school);


        btn_photoStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ستديو
//                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                launcherGallery.launch(intent);
//                //startActivity(intent);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                //launcherGallery.launch(intent);
            }
        });


        btn_addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentName = et_nameStudent.getText().toString();
                String levelStudent = et_levelStudent.getText().toString();
                //السبينر
                String school = sp_school.getSelectedItem().toString();
                //TODO الشغل هان
               // Bitmap bitmap = imageView.setImageBitmap();
                Bitmap bitmap = bitmapPhoto;

                Date date = null;
                int id = 0;

                Student student = new Student(studentName, levelStudent, bitmap, date, id);
                // احصول على ViewModel
                //استدعاء دالة الإضافة
                // myViewModel = new ViewModelProvider(MainActivity.this).get(MyViewModel.class);
                myViewModel.insertStudent(student);

            }
        });


        btn_viewSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SchoolActivity.class);
                startActivity(intent);
            }
        });

        btn_viewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });


    }

    //    ActivityResultLauncher<Intent> launcherGallery = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult o) {
//
//                    if (o.getResultCode() == RESULT_OK && o.getData() != null) {
//                        Uri uri = o.getData().getData();
//                        imageView.setImageURI(uri);
//
//                    }
//
//                }
//            });
    ActivityResultLauncher<Intent> launcherCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {

                    if (o.getResultCode() == RESULT_OK && o.getData() != null) {
                        Bundle bundle = o.getData().getExtras();
//                        Bitmap bitmap = (Bitmap) bundle.get("data");
//                        imageView.setImageBitmap(bitmap);
                        bitmapPhoto = (Bitmap) bundle.get("data");

                    }

                }
            });
}