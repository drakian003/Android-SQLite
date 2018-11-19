package com.example.patryk.lab4.interfaces;


import com.example.patryk.lab4.tables.Group;

import java.util.ArrayList;

public interface IGroupDAO {
    public ArrayList<Group> selectAll();

    public Group selectById(int id);

    public int insert(Group group);

    public boolean update(Group group);

    public boolean delete(Group group);
}
