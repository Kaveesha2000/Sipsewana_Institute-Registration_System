package dao;

import dao.impl.CourseDAOImpl;
import dao.impl.QueryDAOImpl;
import dao.impl.RegisterDAOImpl;
import dao.impl.StudetDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudetDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        STUDENT, COURSE, REGISTER, QUERYDAO
    }
}
