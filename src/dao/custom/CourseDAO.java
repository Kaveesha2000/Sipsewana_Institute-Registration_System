package dao.custom;

import dao.CrudDAO;
import entity.Course;

import java.sql.SQLException;

public interface CourseDAO extends CrudDAO<Course,String> {
    boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
}
