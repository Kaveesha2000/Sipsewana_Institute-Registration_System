package dao.impl;

import dao.custom.RegisterDAO;
import dto.CustomDTO;
import entity.Register;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;
import view.tdm.RegisterDetailTM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {

    @Override
    public boolean add(Register register) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(register);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Register register) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Register search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Register> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean ifRegExist(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT RegId FROM Register WHERE RegId=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1!=null){
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT RegId FROM Register ORDER BY RegId DESC LIMIT 1");
        String s = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (s!=null) {
            int newStudentId = Integer.parseInt(s.replace("R", "")) + 1;
            return String.format("R%03d", newStudentId);
        }
        return "R001";
    }
}
