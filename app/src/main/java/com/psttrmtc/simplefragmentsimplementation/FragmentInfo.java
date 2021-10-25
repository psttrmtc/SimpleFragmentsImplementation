package com.psttrmtc.simplefragmentsimplementation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentInfo extends Fragment {
    SendPos sendPos;
    Student studentInfo;
    int pos = 0;
    TextView mssv;
    TextView name;
    TextView className;
    TextView GPA;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        sendPos = (SendPos) context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_info, parent, false);
        mssv = (TextView) view.findViewById(R.id.mssv);
        name = (TextView) view.findViewById(R.id.name);
        className = (TextView)  view.findViewById(R.id.className);
        GPA = (TextView) view.findViewById(R.id.GPA);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button first = view.findViewById(R.id.firstButton);
        Button previous = view.findViewById(R.id.previousButton);
        Button next = view.findViewById(R.id.nextButton);
        Button last = view.findViewById(R.id.lastButton);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPos.pos(0);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos > 0){
                    sendPos.pos(pos - 1);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPos.pos(pos + 1);
            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPos.pos(-1);
            }
        });

    }
   //Fragment to Activity
    public interface SendPos {
        public void pos(int pos);
    }
// Activity to fragment
    public void displayInfo(int pos, Student student){
        this.pos = pos;
        this.studentInfo = student;
        mssv.setText(student.getMssv());
        name.setText("Họ và tên: " + student.getName());
        className.setText("Lớp: " + student.getClassName());
        GPA.setText("Điểm: " + String.valueOf(student.getGPA()));
    }
}