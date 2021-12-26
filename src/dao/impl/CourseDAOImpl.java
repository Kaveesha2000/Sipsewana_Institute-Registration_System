package dao.impl;

import dao.custom.CourseDAO;
import entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean add(Course course) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Course course) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Course search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Course> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
