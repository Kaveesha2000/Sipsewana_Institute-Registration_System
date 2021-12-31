package bo.custom;

import bo.SuperBO;
import dto.RegisterDTO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegisterBO extends SuperBO {

    boolean registerDetails(RegisterDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getAllDetails() throws SQLException, ClassNotFoundException;

    boolean ifExist(String id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;

    List<CustomDTO> searchDetail(String value);
}
