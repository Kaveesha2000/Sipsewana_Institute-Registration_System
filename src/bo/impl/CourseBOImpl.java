package bo.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dao.custom.StudentDAO;
import dto.CourseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCourse(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
