package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;
import dto.StudentDTO;
import entity.Register;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> getAll();

    List<CustomDTO> searchDetail(String s);
}
