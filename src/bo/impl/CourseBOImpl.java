package bo.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dto.CourseDTO;
import entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws SQLException, ClassNotFoundException {
        ArrayList<CourseDTO> allCourses = new ArrayList<>();
        ArrayList<Course> all = courseDAO.getAll();
        for (Course course : all) {
            allCourses.add(new CourseDTO(course.getCId(),course.getCName(),course.getDuration(),course.getFee()));
        }
        return allCourses;
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        return courseDAO.add(new Course(courseDTO.getCId(),courseDTO.getCName(),courseDTO.getDuration(),courseDTO.getFee()));
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        return courseDAO.update(new Course(courseDTO.getCId(),courseDTO.getCName(),courseDTO.getDuration(),courseDTO.getFee()));
    }

    @Override
    public boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException {
        return courseDAO.ifCourseExist(id);
    }

    @Override
    public boolean deleteCourse(String id) throws SQLException, ClassNotFoundException {
        return courseDAO.delete(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return courseDAO.generateNewID();
    }
}
