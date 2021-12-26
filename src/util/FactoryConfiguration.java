package util;

import entity.Course;
import entity.RegisterDetails;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfigeration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class)
                .addAnnotatedClass(RegisterDetails.class);
        sessionFactory=configuration.buildSessionFactory();

    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfigeration==null)? factoryConfigeration=new FactoryConfiguration() : factoryConfigeration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
