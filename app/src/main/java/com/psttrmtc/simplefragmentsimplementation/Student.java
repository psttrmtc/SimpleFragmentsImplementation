package com.psttrmtc.simplefragmentsimplementation;

public class Student {
    int image;
    int mssv;
    String name;
    int classNumber;
    float GPA;

    public Student(int image, int mssv, String name, int classNumber, float GPA) {
        this.image = image;
        this.mssv = mssv;
        this.name = name;
        this.classNumber = classNumber;
        this.GPA = GPA;
    }

    public int getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public int getClassName() {
        return classNumber;
    }

    public float getGPA() {
        return GPA;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
