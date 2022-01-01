package dao.impl;

import dao.custom.CourseDAO;
import entity.Course;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    public static List<Course> searchCourses(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Course> programs = session.createQuery("FROM Course WHERE CId LIKE '%" + s + "%' or CName LIKE '%" + s + "%'").list();
        transaction.commit();
        session.close();
        return programs;
    }

    @Override
    public boolean add(Course course) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, s);
        session.delete(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course course) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Course search(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, s);
        transaction.commit();
        session.close();
        return course;
    }

    @Override
    public ArrayList<Course> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Course> allCourses = new ArrayList();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course");
        allCourses = (ArrayList<Course>) query.list();
        transaction.commit();
        session.close();
        return allCourses;
    }

    @Override
    public boolean ifCourseExist(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT CId FROM Course WHERE CId=:id");
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
        Query query = session.createSQLQuery("SELECT CId FROM Course ORDER BY CId DESC LIMIT 1");
        String s = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (s!=null) {
            int newCourseId = Integer.parseInt(s.replace("C", "")) + 1;
            return String.format("C%03d", newCourseId);
        }
        return "C001";
    }

    @Override
    public List<String> getCourses() throws SQLException, ClassNotFoundException {
        ArrayList<String> allCourses = new ArrayList();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT CName FROM Course");
        allCourses = (ArrayList<String>) query.list();
        transaction.commit();
        session.close();
        return allCourses;
    }

    @Override
    public Course getCourseDetails(String CName) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course WHERE CName=:CName");
        Course course = (Course) query.setParameter("CName", CName).uniqueResult();
        transaction.commit();
        session.close();
        return course;
    }
}
