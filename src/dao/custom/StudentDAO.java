package dao.custom;

import dao.CrudDAO;
import entity.Student;

import java.math.BigInteger;
import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<Student, String> {
    boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;

    String getStudentName(String id) throws SQLException, ClassNotFoundException;

    BigInteger studentCount() throws SQLException, ClassNotFoundException;
}
