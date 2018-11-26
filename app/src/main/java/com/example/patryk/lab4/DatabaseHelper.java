package com.example.patryk.lab4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.patryk.lab4.dao.GroupDAO;
import com.example.patryk.lab4.dao.StudentDAO;
import com.example.patryk.lab4.dao.StudentGroupDAO;
import com.example.patryk.lab4.tables.Group;
import com.example.patryk.lab4.tables.StudentGroupTable;
import com.example.patryk.lab4.tables.Student;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LAB4.db";
    private SQLiteDatabase db;
    private StudentDAO studentDAO;
    private GroupDAO groupDAO;
    private StudentGroupDAO studentGroupDAO;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, version);
        db = getWritableDatabase();
        studentDAO = new StudentDAO(db);
        groupDAO = new GroupDAO(db);
        studentGroupDAO = new StudentGroupDAO(db);
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public StudentGroupDAO getStudentGroupDAO() {
        return studentGroupDAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
        Student.onCreate(db);
        Group.onCreate(db);
        StudentGroupTable.onCreate(db);
        insertSomeTestData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Student.onUpgrade(db);
        Group.onUpgrade(db);
        StudentGroupTable.onUpgrade(db);
        onCreate(db);
    }

    private void insertSomeTestData(SQLiteDatabase db){
        db.execSQL("INSERT INTO "+Student.TABLE_NAME+"("+Student.ID_COLUMN+", "+Student.NAME_COLUMN+", "+Student.LAST_NAME_COLUMN+") VALUES (null, 'Patryk', 'Juszczynka')");
        db.execSQL("INSERT INTO "+Student.TABLE_NAME+"("+Student.ID_COLUMN+", "+Student.NAME_COLUMN+", "+Student.LAST_NAME_COLUMN+") VALUES (null, 'Jan', 'Kowalski')");
        db.execSQL("INSERT INTO "+Student.TABLE_NAME+"("+Student.ID_COLUMN+", "+Student.NAME_COLUMN+", "+Student.LAST_NAME_COLUMN+") VALUES (null, 'Andrzej', 'Nowak')");
        db.execSQL("INSERT INTO "+Student.TABLE_NAME+"("+Student.ID_COLUMN+", "+Student.NAME_COLUMN+", "+Student.LAST_NAME_COLUMN+") VALUES (null, 'Anna', 'Maria')");

        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Wykladowa_1')");
        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Wykladowa_2')");
        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Wykladowa_3')");

        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Cwieczeniowa_1')");
        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Cwieczeniowa_2')");
        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Cwieczeniowa_3')");

        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Laboratoryjna_1')");
        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Laboratoryjna_2')");
        db.execSQL("INSERT INTO "+Group.TABLE_NAME+"("+Group.ID_COLUMN+", "+Group.NAME_COLUMN+") VALUES (null, 'Laboratoryjna_3')");

        db.execSQL("INSERT INTO "+StudentGroupTable.TABLE_NAME+"("+StudentGroupTable.ID_COLUMN+", "+StudentGroupTable.STUDENT_ID_COLUMN+", "+StudentGroupTable.GROUP_ID_COLUMN+") VALUES (null, 1, 1)");
        db.execSQL("INSERT INTO "+StudentGroupTable.TABLE_NAME+"("+StudentGroupTable.ID_COLUMN+", "+StudentGroupTable.STUDENT_ID_COLUMN+", "+StudentGroupTable.GROUP_ID_COLUMN+") VALUES (null, 1, 2)");
        db.execSQL("INSERT INTO "+StudentGroupTable.TABLE_NAME+"("+StudentGroupTable.ID_COLUMN+", "+StudentGroupTable.STUDENT_ID_COLUMN+", "+StudentGroupTable.GROUP_ID_COLUMN+") VALUES (null, 2, 1)");
        db.execSQL("INSERT INTO "+StudentGroupTable.TABLE_NAME+"("+StudentGroupTable.ID_COLUMN+", "+StudentGroupTable.STUDENT_ID_COLUMN+", "+StudentGroupTable.GROUP_ID_COLUMN+") VALUES (null, 3, 3)");
        db.execSQL("INSERT INTO "+StudentGroupTable.TABLE_NAME+"("+StudentGroupTable.ID_COLUMN+", "+StudentGroupTable.STUDENT_ID_COLUMN+", "+StudentGroupTable.GROUP_ID_COLUMN+") VALUES (null, 4, 4)");
    }


}
