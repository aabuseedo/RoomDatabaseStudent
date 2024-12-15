package com.example.roomdatabasestudent.roomDatabase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasestudent.R;
import com.example.roomdatabasestudent.roomDatabase.entity.School;

import java.util.ArrayList;
import java.util.List;

public class SchoolAdapter  extends RecyclerView.Adapter<SchoolAdapter.MyHolderSchool>{

    Context context;
    ArrayList<School> schools;

    public SchoolAdapter(Context context, ArrayList<School> schools) {
        this.context = context;
        this.schools = schools;
    }

    @NonNull
    @Override
    public MyHolderSchool onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.school_item, null, false);
        MyHolderSchool myHolderSchool = new MyHolderSchool(view);
        return myHolderSchool;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderSchool holder, int position) {
        School school = schools.get(position);
        holder.tv_name_School.setText(school.getNameSchool());
        holder.tv_noStudent_course.setText(school.getStudentNo()+""); //TODO ملاحظة رقم او عدد الطلاب نوع المتغير int
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    //TODO دالة تحديث االبيانات

    public void refreshDataSchool(List<School> schools) {
        this.schools.clear();
        this.schools.addAll(schools);
        notifyDataSetChanged();
    }
    public static class MyHolderSchool extends RecyclerView.ViewHolder {

        TextView tv_name_School,tv_noStudent_course;
        public MyHolderSchool(@NonNull View itemView) {
            super(itemView);
            tv_name_School=itemView.findViewById(R.id.tv_name_School);
            tv_noStudent_course=itemView.findViewById(R.id.tv_noStudent_course);

        }
    }
}
