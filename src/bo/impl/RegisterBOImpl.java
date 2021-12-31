package bo.impl;

import bo.custom.RegisterBO;
import dao.DAOFactory;
import dao.custom.*;

import dto.RegisterDTO;
import dto.CustomDTO;
import entity.Course;
import entity.Register;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTER);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public boolean registerDetails(RegisterDTO dto) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, dto.getSId());
        Course course = session.get(Course.class, dto.getCId());

        Register register = new Register(dto.getRegId(), dto.getRegDate(), student, course);
        //RegisterDetail registerDetail =null;

        session.save(register);
        //session.save(registerDetail);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<CustomDTO> getAllDetails() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> allDetails = new ArrayList<>();
        ArrayList<CustomDTO> all = queryDAO.getAll();
        for (CustomDTO register : all) {
            allDetails.add(new CustomDTO(register.getRegId(),register.getSId(),register.getSName(),
                    register.getCId(),register.getCName(),register.getRegDate()));
        }
        return allDetails;
    }

    @Override
    public boolean ifExist(String id) throws SQLException, ClassNotFoundException {
        return registerDAO.ifRegExist(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return registerDAO.generateNewID();
    }

    @Override
    public List<CustomDTO> searchDetail(String value) {
        return queryDAO.searchDetail(value);
    }
}
