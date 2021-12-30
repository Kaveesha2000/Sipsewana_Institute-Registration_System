package dao.impl;

import dao.custom.QueryDAO;
import dto.CustomDTO;
import entity.Register;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.time.LocalDate;
import java.util.ArrayList;


public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomDTO> getAll() {
        ArrayList<CustomDTO> allDetails = new ArrayList();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT r.RegId,s.SId,s.SName,c.CId,c.CName,r.RegDate FROM Register r INNER JOIN Student s ON r.student=s.SId INNER JOIN Course c ON r.course=c.CId");
        ArrayList<Object[]> details = (ArrayList<Object[]>) query.list();
        transaction.commit();
        session.close();
        for (Object[] temp:details) {
            allDetails.add(new CustomDTO(
                    (String) temp[0],
                    (String) temp[1],
                    (String) temp[2],
                    (String) temp[3],
                    (String) temp[4],
                    (LocalDate) temp[5]
            ));
        }
        return allDetails;
    }
}
