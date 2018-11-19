package com.example.patryk.lab4.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.patryk.lab4.interfaces.IGroupDAO;
import com.example.patryk.lab4.tables.Group;
import com.example.patryk.lab4.tables.Group;

import java.util.ArrayList;

public class GroupDAO implements IGroupDAO {
    
    String tableName = Group.TABLE_NAME;
    String[] projection;
    protected SQLiteDatabase db;

    public GroupDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public ArrayList<Group> selectAll() {
        Cursor cursor = db.query(
                this.tableName,         // The table to query
                this.projection,        // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                null               // The sort order
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

    public Group selectById(int id) {
        String[] selectionArgs = {id + ""};
        Cursor cursor = db.query(
                this.tableName,         // The table to query
                this.projection,        // The array of columns to return (pass null to get all)
                Group.ID_COLUMN + " = ?",              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                null               // The sort order
        );

        long itemId = 0;
        String itemName = "";
        String itemSurName = "";
        while (cursor.moveToNext()) {
            itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Group.ID_COLUMN));
            itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Group.NAME_COLUMN));
        }
        cursor.close();

        Group group = new Group((int) itemId, itemName);
        return group;

    }

    public int insert(Group group) {
        ContentValues values = new ContentValues();

        values.put(Group.NAME_COLUMN, group.getName());

        return (int) db.insert(this.tableName, null, values);

    }

    public boolean update(Group group) {
        ContentValues values = new ContentValues();

        values.put(Group.NAME_COLUMN, group.getName());
        return db.update(Group.TABLE_NAME, values, Group.ID_COLUMN + "=" + group.getId(), null) > 0;

    }

    public boolean delete(Group group) {
        return db.delete(Group.TABLE_NAME, Group.ID_COLUMN + "=" + group.getId(), null) > 0;

    }
}
