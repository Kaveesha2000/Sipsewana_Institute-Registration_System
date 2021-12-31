package dao.impl;

import dao.custom.QueryDAO;
import dto.CustomDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;


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

    public List<CustomDTO> searchDetail(String s) {

        ArrayList<CustomDTO> allDetails = new ArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Object[]> details = session.createSQLQuery("SELECT r.RegId,s.SId,s.SName,c.CId,c.CName,r.RegDate FROM Register r INNER JOIN Student s ON r. student_SId=s.SId INNER JOIN Course c ON r. course_CId=c.CId WHERE CId LIKE '%" + s + "%' or CName LIKE '%" + s + "%' ").list();

        transaction.commit();
        session.close();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        /*String text = df.format(details.get(1)[5]);*/
        /*System.out.println(text);
        LocalDate parse = LocalDate.parse(text);
        System.out.println(parse);*/

        for (Object[] temp:details) {
            allDetails.add(new CustomDTO(
                    (String) temp[0],
                    (String) temp[1],
                    (String) temp[2],
                    (String) temp[3],
                    (String) temp[4],
                    LocalDate.parse(df.format(temp[5]))
            ));
        }

        return allDetails;
    }
}
