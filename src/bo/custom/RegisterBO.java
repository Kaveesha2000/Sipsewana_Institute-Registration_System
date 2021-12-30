package bo.custom;

import bo.SuperBO;
import dto.RegisterDTO;
import dto.RegisterDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RegisterBO extends SuperBO {

    boolean registerDetails(RegisterDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<RegisterDetailDTO> getAllDetails() throws SQLException, ClassNotFoundException;

    boolean ifExist(String id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;
}
