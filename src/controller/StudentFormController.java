package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tdm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentFormController {
    public Button btnSave;
    public AnchorPane studentContext;
    public Label lblSId;
    public JFXTextField txtSName;
    public JFXTextField txtDOB;
    public JFXTextField txtAddress;
    public JFXTextField txtNIC;
    public JFXTextField txtPhoneNo;
    public TableView<StudentTM> tblStudent;
    public JFXComboBox<String> cmbCourse;
    public JFXTextField txtSearchBar;
    public TableColumn colRegNo;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDOB;
    public TableColumn colNIC;
    public TableColumn colPhoneNo;
    public TableColumn colCourse;

    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.STUDENT);

    public void initialize(){

        lblSId.setText(generateNewId());
        lblSId.setDisable(true);

        colRegNo.setCellValueFactory(new PropertyValueFactory<>("SId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("SName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("TNo"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("Course"));

        loadAllStudents();
        //btnSave.setDisable(true);

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lblSId.setText(newValue.getSId());
                txtSName.setText(newValue.getSName());
                txtAddress.setText(newValue.getAddress());
                txtDOB.setText(newValue.getDOB());
                txtNIC.setText(newValue.getNIC());
                txtPhoneNo.setText(newValue.getTNo());
                cmbCourse.setValue(newValue.getCourse());
                lblSId.setDisable(true);
                btnSave.setDisable(true);
            }
        });
    }

    private void loadAllStudents() {
        tblStudent.getItems().clear();
        try {
            ArrayList<StudentDTO> allStudents = studentBO.getAllStudents();
            for (StudentDTO student : allStudents) {
                tblStudent.getItems().add(new StudentTM(student.getSId(),student.getSName(),student.getAddress(),student.getDOB(),
                        student.getNIC(),student.getTNo(),student.getCourse()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    public void saveOnAction(ActionEvent actionEvent) {

        String id=lblSId.getText();
        String name=txtSName.getText();
        String address=txtAddress.getText();
        String dob=txtDOB.getText();
        String nic=txtNIC.getText();
        String phoneNo= txtPhoneNo.getText();
        String course=cmbCourse.getValue();

        try {
            if (existStudent(id)) {
                new Alert(Alert.AlertType.ERROR, id + " Already Exists").show();
            }
            else{
                new Alert(Alert.AlertType.CONFIRMATION,  "Saved...!").show();
                clear();
                StudentDTO studentDTO = new StudentDTO(id, name, address, dob, nic, phoneNo, course);
                studentBO.addStudent(studentDTO);
                tblStudent.getItems().add(new StudentTM(id, name, address, dob, nic, phoneNo, course));
                lblSId.setText(generateNewId());
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean existStudent(String id) throws SQLException, ClassNotFoundException {
        return studentBO.ifStudentExist(id);
    }

    public void updateOnAction(ActionEvent actionEvent) {

        String id=lblSId.getText();
        String name=txtSName.getText();
        String address=txtAddress.getText();
        String dob=txtDOB.getText();
        String nic=txtNIC.getText();
        String phoneNo= txtPhoneNo.getText();
        String course=cmbCourse.getValue();


        try {
            if (!existStudent(id)) {
                new Alert(Alert.AlertType.ERROR, id + " There is no such student associated with the id "+id).show();
            }
            else {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated...!").show();
                clear();
                StudentDTO studentDTO = new StudentDTO(id, name, address, dob, nic, phoneNo, course);
                studentBO.updateStudent(studentDTO);
                lblSId.setText(generateNewId());
                btnSave.setDisable(false);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to update the student " + id + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        StudentTM selectedStudent = tblStudent.getSelectionModel().getSelectedItem();
        selectedStudent.setSName(name);
        selectedStudent.setAddress(address);
        selectedStudent.setDOB(dob);
        selectedStudent.setNIC(nic);
        selectedStudent.setTNo(phoneNo);
        selectedStudent.setCourse(course);
        tblStudent.refresh();
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id = tblStudent.getSelectionModel().getSelectedItem().getSId();
        try {
            if (!existStudent(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such student associated with the id " + id).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted...!").show();
                studentBO.deleteStudent(id);
                tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
                tblStudent.getSelectionModel().clearSelection();
                clear();
                lblSId.setText(generateNewId());
                btnSave.setDisable(false);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the student " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void moveToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    private String generateNewId() {
        try {
            return studentBO.generateNewID();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (tblStudent.getItems().isEmpty()) {
            return "S001";
        } else {
            String id = getLastStudentId();
            int newCustomerId = Integer.parseInt(id.replace("S", "")) + 1;
            return String.format("S%03d", newCustomerId);
        }
    }

    private String getLastStudentId() {
        List<StudentTM> tempStudentList = new ArrayList<>(tblStudent.getItems());
        Collections.sort(tempStudentList);
        return tempStudentList.get(tempStudentList.size() - 1).getSId();
    }

    private void clear() {
        txtSName.clear();
        txtSName.clear();
        txtAddress.clear();
        txtDOB.clear();
        txtNIC.clear();
        txtPhoneNo.clear();
        cmbCourse.getSelectionModel().clearSelection();
    }

}
