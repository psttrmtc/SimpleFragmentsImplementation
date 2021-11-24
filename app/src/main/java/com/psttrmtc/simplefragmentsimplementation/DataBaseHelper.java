package com.psttrmtc.simplefragmentsimplementation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String HOCSINH_TABLE = "HOCSINH";
    public static final String MAHS_COLUMN = "MAHS";
    public static final String TENHS_COLUMN = "TENHS";
    public static final String LOP_TABLE = "LOP";
    public static final String MALOP_COLUMN = "MA" + LOP_TABLE;
    public static final String TENLOP_COLUMN = "TENLOP";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createHSTableStatement = "CREATE TABLE IF NOT EXISTS " + HOCSINH_TABLE + " ("
                + MAHS_COLUMN + " INTEGER PRIMARY KEY , "
                + TENHS_COLUMN + " TEXT, "
                + MALOP_COLUMN + " INT)";
//        String createLopTableStatement = "CREATE TABLE IF NOT EXISTS " + LOP_TABLE + " (" + MALOP_COLUMN + " INTEGER PRIMARY KEY , " + TENLOP_COLUMN + " TEXT)";
//        try {
//            db.execSQL(createHSTableStatement);
//            db.execSQL(createLopTableStatement);
//        } catch (SQLException e) {
//            Log.d("SQL exec", e.toString());
//        }
        try {
            db.execSQL(createHSTableStatement);

        } catch (SQLException e) {
            Log.d("SQL exec", e.toString());
        }
//        addOneClass(16, "K16");
//        addOneClass(18, "K18");
        addOneStudent(db, new Student(1,1612168,"Bùi Minh Hải",16, 8));
        addOneStudent(db, new Student(2,18120441,"Nguyễn Minh Lợi",18, 8));
        addOneStudent(db, new Student(3,1612215,"Nguyễn Thanh Hoàng",16, 8));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOneStudent(SQLiteDatabase db,Student student){

        ContentValues cv = new ContentValues();
        cv.put(MAHS_COLUMN, student.getMssv());
        cv.put(TENHS_COLUMN, student.getName());
        cv.put(MALOP_COLUMN, student.getClassName());
        long insert = db.insert(HOCSINH_TABLE, null, cv);
        if (insert == -1){

            return false;
        }else{

            return true;
        }
    }
    public boolean addOneClass(SQLiteDatabase db,int classNumber, String className){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MALOP_COLUMN, classNumber);
        cv.put(TENLOP_COLUMN, className);
        long insert = db.insert(LOP_TABLE, null, cv);
        if(insert == -1){

            return false;
        }else{

            return true;
        }
    }
    public List<Student> getStudents(){
        List<Student> returnList = new ArrayList<>();

        String queryString ="SELECT * FROM " + HOCSINH_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            do{
                int maHS = cursor.getInt(0);
                String tenHS = cursor.getString(1);
                int maLop = cursor.getInt(2);
                Student newStudent = new Student(1, maHS, tenHS, maLop, 8);
                returnList.add(newStudent);
            }while (cursor.moveToNext());
        }else {

        }
        cursor.close();
        db.close();
        return returnList;
    }
}
