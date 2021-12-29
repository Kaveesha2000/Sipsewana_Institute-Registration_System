package bo;

import bo.impl.CourseBOImpl;
import bo.impl.RegisterBOImpl;
import bo.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case COURSE:
                return new CourseBOImpl();
            case REGISTERDETAILS:
                return new RegisterBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        STUDENT, COURSE, REGISTERDETAILS
    }
}
