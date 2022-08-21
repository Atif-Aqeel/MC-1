package com.atifaqeel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    //psfs --->  public static final String
    public static final String STUDENT_ID = "StudentID";
    public static final String STUDENT_NAME = "StudentName";
    public static final String STUDENT_ROLL = "StudentRollNumber";
    public static final String STUDENT_ENROLL = "IsEnrolled";
    public static final String STUDENT_TABLE = "StudentTable";

    //Constructor
    public DBHelper(@Nullable Context context) {
        //super() invokes superclass constructor
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL Query to create Table
        //String createTableStatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
        //OR By 2nd Method
        String createTableStatement = "CREATE TABLE " + STUDENT_TABLE + "(" +
                STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT, " +
                STUDENT_NAME + " Text, " +
                STUDENT_ROLL + " Int, " +
                STUDENT_ENROLL + " BOOL) ";
        db.execSQL(createTableStatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }


    //Add Student
    public void  addStudent(StudentModel STUDENTModel){
        SQLiteDatabase db = this.getWritableDatabase();

        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(STUDENT_NAME, STUDENTModel.getName());
        cv.put(STUDENT_ROLL, STUDENTModel.getRollNmber());
        cv.put(STUDENT_ENROLL, STUDENTModel.isEnroll());

        db.insert(STUDENT_TABLE, null, cv);
        db.close();

        //NullCoumnHack
        //long insert =
        //if (insert == -1) { return false; }
        //else{return true;}
    }


    //Get All Student
    public ArrayList<StudentModel> getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();

        //generate query to read from db
        String string = "SELECT * FROM " + STUDENT_TABLE;
        Cursor cursorCourses = db.rawQuery(string, null);

        ArrayList<StudentModel> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new StudentModel(
                        cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return studentArrayList;
    }


    //Update Student by STUDENT_ROLL
    public void updateStudent(StudentModel STUDENTModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(STUDENT_NAME, STUDENTModel.getName());
        cv.put(STUDENT_ROLL, STUDENTModel.getRollNmber());
        cv.put(STUDENT_ENROLL, STUDENTModel.isEnroll());

        //lets update now
        db.update(STUDENT_TABLE, cv, STUDENT_ROLL + "=?",
                new String[]{String.valueOf(STUDENTModel.getRollNmber())});
    }


    //delete Student By STUDENT_ROLL
    public void deleteStudent(StudentModel STUDENTModel ){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(STUDENT_TABLE, STUDENT_ROLL + "=?",
                new String[]{String.valueOf(STUDENTModel.getRollNmber())} );
        db.close();
    }




}
