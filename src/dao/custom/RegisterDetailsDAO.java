package dao.custom;

import dao.CrudDAO;
import entity.RegisterDetails;

import java.sql.SQLException;

public interface RegisterDetailsDAO extends CrudDAO<RegisterDetails,String> {
    boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException;
}
