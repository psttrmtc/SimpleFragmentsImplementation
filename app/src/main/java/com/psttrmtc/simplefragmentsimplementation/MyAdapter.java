package com.psttrmtc.simplefragmentsimplementation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Student> {
    List<Student> studentList;
    Context context;
    int resource;
    public MyAdapter(Context context, int resource, List<Student> studentList){
        super(context,resource,studentList);
        this.context = context;
        this.resource = resource;
        this.studentList = studentList;
    }
    @Override
    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(context);

        View view = inflater.inflate(resource, null, false);

        ImageView imageView = view.findViewById(R.id.profileImage);
        TextView textView  = view.findViewById(R.id.profileInfo);

        Student student = studentList.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(student.getImage()));
        textView.setText(student.getMssv());
        return view;
    }
}
