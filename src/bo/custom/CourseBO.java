package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseBO extends SuperBO {
    ArrayList<CourseDTO> getAllCourses() throws SQLException, ClassNotFoundException;

    boolean addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException;

    boolean updateCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException;

    boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException;

    boolean deleteCourse(String id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;
}
