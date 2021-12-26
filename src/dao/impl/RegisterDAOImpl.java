package dao.impl;

import dao.custom.RegisterDetailsDAO;
import entity.RegisterDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAOImpl implements RegisterDetailsDAO {
    @Override
    public boolean add(RegisterDetails registerDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(RegisterDetails registerDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RegisterDetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RegisterDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
