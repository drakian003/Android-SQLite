package com.example.patryk.lab4.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.patryk.lab4.interfaces.IStudentGroupDAO;
import com.example.patryk.lab4.tables.Group;
import com.example.patryk.lab4.tables.Student;
import com.example.patryk.lab4.tables.StudentGroupTable;

import java.util.ArrayList;

public class StudentGroupDAO implements IStudentGroupDAO {

    String tableName = StudentGroupTable.TABLE_NAME;
    String[] projection;
    protected SQLiteDatabase db;

    public StudentGroupDAO(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public ArrayList<Group> selectAll(int id) {
        //SELECT * FROM Studenci inner join Grupy_studenta on Studenci.Id_studenta = Grupy_studenta.Id_studenta inner join Grupy on Grupy.Id_grupy = Grupy_studenta.Id_grupy;
        String rawQuery = "SELECT Grupy.Id_grupy, Grupy.Nazwa FROM Studenci " +
                "inner join Grupy_studenta on Studenci.Id_studenta = Grupy_studenta.Id_studenta " +
                "inner join Grupy on Grupy.Id_grupy = Grupy_studenta.Id_grupy " +
                "WHERE Studenci.Id_studenta = "+ id +";";
        Cursor cursor = db.rawQuery(
                rawQuery,
                null
        );

        ArrayList<Group> groups = new ArrayList<Group>();

        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Group.ID_COLUMN));
            String itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Group.NAME_COLUMN));

            groups.add(new Group((int) itemId, itemName ));
        }
        cursor.close();

        return groups;
    }

    @Override
    public Group selectById(int id) {
        return null;
    }

    @Override
    public int insert(StudentGroupTable studentGroupTable) {
        return 0;
    }

    @Override
    public boolean update(StudentGroupTable studentGroupTable) {
        return false;
    }

    @Override
    public boolean delete(StudentGroupTable studentGroupTable) {
        return false;
    }
}
