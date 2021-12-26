package bo.impl;

import bo.custom.RegisterDetailsBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dao.custom.QueryDAO;
import dao.custom.StudentDAO;
import dto.RegisterDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDetailsBOImpl implements RegisterDetailsBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public ArrayList<RegisterDetailsDTO> getAllDetails() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean ifExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
