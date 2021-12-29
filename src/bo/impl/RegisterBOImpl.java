package bo.impl;

import bo.custom.RegisterBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dao.custom.QueryDAO;
import dao.custom.RegisterDAO;
import dao.custom.StudentDAO;
import dto.RegisterDTO;


import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterBOImpl implements RegisterBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTERDETAILS);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public boolean registerDetails(RegisterDTO dto) throws SQLException, ClassNotFoundException {
        /*Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, dto.getSId());
        Course course = session.get(Course.class, dto.getCId());

        Register register = new Register(dto.getRegId(),dto.getRegDate(),student,course);
        Register register1 =null;
        Course course1=null;

        for (RegisterDTO detail : dto.get()) {
            item = session.get(Item.class, detail.getItemCode());
            orderDetailDTO = new OrderDetails(order,item,detail.getOrderQty(),detail.getDiscount());
            int remainingQty = item.getQtyOnHand() - detail.getOrderQty();
            item.setQtyOnHand(remainingQty);
        }
        session.save(order);
        session.save(orderDetailDTO);
        session.update(item);
        transaction.commit();
        session.close();*/
        return true;
    }

    @Override
    public ArrayList<RegisterDTO> getAllDetails() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean ifExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return registerDAO.generateNewID();
    }
}
