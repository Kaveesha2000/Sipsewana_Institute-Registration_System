package bo.impl;

import bo.custom.RegisterBO;
import dao.DAOFactory;
import dao.custom.*;
import dao.impl.RegisterDetailsDAOImpl;
import dto.RegisterDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Register;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<RegisterDTO> getAllDetails() throws SQLException, ClassNotFoundException {
        System.out.println("Enter In BoImpl");
        ArrayList<RegisterDTO> allDetails = new ArrayList<>();
        ArrayList<Register> all = registerDAO.getAll();
        System.out.println("End In BoImpl");
        System.out.println(all);
        for (Register register : all) {
            allDetails.add(new RegisterDTO(register.getRegId(),register.getStudent().getSId(),register.getCourse().getCId(),
                    register.getRegDate()));
            System.out.println(register.getRegId());
        }
        System.out.println(allDetails);
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
}
