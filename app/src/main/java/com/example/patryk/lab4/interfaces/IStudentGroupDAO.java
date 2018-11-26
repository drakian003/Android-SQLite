package com.example.patryk.lab4.interfaces;

import com.example.patryk.lab4.tables.Group;
import com.example.patryk.lab4.tables.StudentGroupTable;

import java.util.ArrayList;

public interface IStudentGroupDAO {
    public ArrayList<Group> selectAll(int id);

    public Group selectById(int id);

    public int insert(StudentGroupTable studentGroupTable);

    public boolean update(StudentGroupTable studentGroupTable);

    public boolean delete(StudentGroupTable studentGroupTable);

}
