package com.example.roomdatabasestudent.roomDatabase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasestudent.R;
import com.example.roomdatabasestudent.roomDatabase.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyHolderStudent> {

    Context context;
    ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public MyHolderStudent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, null, false);
        StudentAdapter.MyHolderStudent myHolderStudent = new MyHolderStudent(view);
        return myHolderStudent;

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderStudent holder, int position) {
        Student student = students.get(position);
        holder.tv_name_student.setText(student.getName());
        holder.tv_level_student.setText(student.getLevel());
        holder.tv_date_student.setText(student.getBirthDate() + ""); //TODO ملاحظة المتغير نوعه هنا date
        holder.tv_schoolName_student.setText(student.getIdSchool());//TODO هيستدعي بهيك حالة ال id الخاص بالمدرسة وليس اسمها ؟؟
        //   holder.img_student.setText(student.getPhoto());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    //TODO دالة تحديث االبيانات

    public void refreshDataStudent(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    public static class MyHolderStudent extends RecyclerView.ViewHolder {
        TextView tv_name_student, tv_level_student, tv_date_student, tv_schoolName_student;
        ImageView img_student;

        public MyHolderStudent(@NonNull View itemView) {
            super(itemView);
            tv_name_student = itemView.findViewById(R.id.tv_name_student);
            tv_level_student = itemView.findViewById(R.id.tv_level_student);
            tv_date_student = itemView.findViewById(R.id.tv_date_student);
            tv_schoolName_student = itemView.findViewById(R.id.tv_schoolName_student);
            img_student = itemView.findViewById(R.id.img_student);

        }
    }
}
