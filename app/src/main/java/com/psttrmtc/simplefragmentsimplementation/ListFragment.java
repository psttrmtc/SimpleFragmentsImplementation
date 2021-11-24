package com.psttrmtc.simplefragmentsimplementation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    public SendInfo sendInfo;
    List<Student> studentList;
    ListView listView;
    TextView textView;
    public Student sendStudentInfo;
    public int pos = 0;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        sendInfo = (SendInfo) context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list, parent, false);
        studentList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView);
        textView = (TextView) view.findViewById(R.id.textView);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this.getActivity());
        studentList = dataBaseHelper.getStudents();
        studentList.get(0).setImage(R.drawable.icon_1);
        studentList.get(1).setImage(R.drawable.icon_2);
        studentList.get(2).setImage(R.drawable.icon_3);
        MyAdapter adapter = new MyAdapter(view.getContext(), R.layout.list_item, studentList);
        sendStudentInfo = studentList.get(pos);
        textView.setText(String.valueOf(sendStudentInfo.getMssv()));
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
//        sendInfo.sentStudent(pos, sendStudentInfo);
        listView.setOnItemClickListener((adapterView, view1, position, l) -> {
            Student student = studentList.get(position);
            textView.setText(String.valueOf(student.getMssv()));
            sendInfo.sentStudent(pos, student);
        });

    }
    //Fragment to Activity
    public interface SendInfo{
        void sentStudent(int pos, Student student);
    }
    //Activity to Fragment
    public void receivePos(int pos){
        sendStudentInfo = studentList.get(pos);
        this.pos = pos;
        textView.setText(String.valueOf(sendStudentInfo.getMssv()));
        sendInfo.sentStudent(pos, sendStudentInfo);
        listView.post(new Runnable() {
            @Override
            public void run() {
                listView.requestFocusFromTouch();
                listView.setSelection(pos);

            }
        });

    }

}