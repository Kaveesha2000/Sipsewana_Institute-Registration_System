package dao.custom;

import dao.CrudDAO;
import entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO extends CrudDAO<Course, String> {
    boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;

    List<String> getCourses() throws SQLException, ClassNotFoundException;

    Course getCourseDetails(String CName) throws SQLException, ClassNotFoundException;
}
