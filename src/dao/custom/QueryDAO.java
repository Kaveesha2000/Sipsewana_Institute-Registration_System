package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;
import dto.StudentDTO;
import entity.Register;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> getAll();
}
