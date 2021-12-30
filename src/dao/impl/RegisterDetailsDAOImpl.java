package dao.impl;

import dao.custom.RegisterDetailDAO;
import entity.Register;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDetailsDAOImpl implements RegisterDetailDAO {


    public boolean add(Register registerDetail) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(registerDetail);
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
        ArrayList<Register> allDetails = new ArrayList();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Register");
        allDetails = (ArrayList<Register>) query.list();
        transaction.commit();
        session.close();
        return allDetails;
    }
}
