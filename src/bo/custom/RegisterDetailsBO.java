package bo.custom;

import bo.SuperBO;
import dto.RegisterDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RegisterDetailsBO extends SuperBO {
    ArrayList<RegisterDetailsDTO> getAllDetails() throws SQLException, ClassNotFoundException;

    boolean ifExist(String id) throws SQLException, ClassNotFoundException;
}
