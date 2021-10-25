package com.psttrmtc.simplefragmentsimplementation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class MainActivity extends FragmentActivity implements ListFragment.SendInfo, FragmentInfo.SendPos {
    private Student studentInfo;
    private int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.listContainer, new ListFragment());
        ft.replace(R.id.infoContainer, new FragmentInfo());
        ft.commit();
    }
    @Override
    public void sentStudent(int pos, Student student){
        this.pos = pos;
        this.studentInfo = student;
        FragmentManager manager = getSupportFragmentManager();
        FragmentInfo fragmentInfo = (FragmentInfo) manager.findFragmentById(R.id.infoContainer);
        fragmentInfo.displayInfo(pos, studentInfo);
    }
    @Override
    public void pos(int pos){
        FragmentManager manager = getSupportFragmentManager();
        ListFragment listFragment = (ListFragment) manager.findFragmentById(R.id.listContainer);
        List<Student> _studentList = listFragment.studentList;
        if (pos == -1){
            int last = _studentList.size() -1;
            listFragment.sendInfo.sentStudent(last , _studentList.get(last));
        }else if (pos == 0){
            listFragment.sendInfo.sentStudent(0, _studentList.get(0));
        }else if (pos < _studentList.size()){
            listFragment.sendInfo.sentStudent(pos, _studentList.get(pos));
        }
    }
}