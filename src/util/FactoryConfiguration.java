package util;

import entity.Course;
import entity.RegisterDetails;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/*public class FactoryConfiguration {
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
}*/

public class FactoryConfiguration {
    private  static FactoryConfiguration factoryConfiguration;

    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).addAnnotatedClass(RegisterDetails.class);
        sessionFactory = configuration.setProperties(properties).buildSessionFactory();
    }

    public  static FactoryConfiguration getInstance(){
        if (factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
/*
public class FactoryConfiguration {
    private static SessionFactory sessionFactory= createSession();

    private static SessionFactory createSession() {
        StandardServiceRegistry stg =
                new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();
        Metadata metadata=new MetadataSources(stg)
                .addAnnotatedClass(Course.class)
                .getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getInstance(){
        return sessionFactory;
    }
}*/
