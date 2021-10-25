package com.psttrmtc.simplefragmentsimplementation;

public class Student {
    int image;
    String mssv;
    String name;
    String className;
    float GPA;

    public Student(int image, String mssv, String name, String className, float GPA) {
        this.image = image;
        this.mssv = mssv;
        this.name = name;
        this.className = className;
        this.GPA = GPA;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public float getGPA() {
        return GPA;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
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
