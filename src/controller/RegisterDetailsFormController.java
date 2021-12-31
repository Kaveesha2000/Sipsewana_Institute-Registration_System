package controller;

import bo.BOFactory;
import bo.custom.RegisterBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.impl.CourseDAOImpl;
import dao.impl.QueryDAOImpl;
import dao.impl.RegisterDAOImpl;
import dao.impl.StudetDAOImpl;
import dto.RegisterDTO;
import dto.CustomDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tdm.RegisterDetailTM;
import view.tdm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegisterDetailsFormController {
    public AnchorPane registrationDetailContext;
    public TableView<RegisterDetailTM> tblRegistrationDetails;
    public TableColumn colSId;
    public TableColumn colSName;
    public TableColumn colCId;
    public TableColumn colCName;
    public TableColumn colRegDate;
    public TableColumn colRegId;
    public JFXTextField txtSearchBar;
    public JFXTextField txtSName;
    public JFXTextField txtSId;
    public Label lblRegId;
    public JFXTextField txtCourseId;
    public JFXComboBox<String> cmbCourse;
    public JFXTextField txtFee;
    public JFXTextField txtDuration;
    public CheckBox checkBox;
    public Button regBtn;

    StudentDTO newStudent;

    private final RegisterBO registerBO = (RegisterBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REGISTER);

    public void initialize(){

        lblRegId.setText(generateNewId());
        lblRegId.setDisable(true);

        regBtn.setDisable(true);

        colRegId.setCellValueFactory(new PropertyValueFactory<>("RegId"));
        colSId.setCellValueFactory(new PropertyValueFactory<>("SId"));
        colSName.setCellValueFactory(new PropertyValueFactory<>("SName"));
        colCId.setCellValueFactory(new PropertyValueFactory<>("CId"));
        colCName.setCellValueFactory(new PropertyValueFactory<>("CName"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));

        loadAllDetails();

        try {
            loadCourseDetails();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                getCourseDetails(newValue);
            }

        });

        txtSearchBar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchStore(newValue);
            }
        });

    }


    private void loadAllDetails() {
        tblRegistrationDetails.getItems().clear();
        try {
            ArrayList<CustomDTO> allDetails = registerBO.getAllDetails();
             for (CustomDTO detail : allDetails) {
                tblRegistrationDetails.getItems().add(new RegisterDetailTM(detail.getRegId(),detail.getSId(),detail.getSName(),
                        detail.getCId(),detail.getCName(),detail.getRegDate()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    private void getCourseDetails(String newValue) {
        try {
            Course courseDetails = new CourseDAOImpl().getCourseDetails(newValue);
            txtCourseId.setText(courseDetails.getCId());
            txtDuration.setText(courseDetails.getDuration());
            txtFee.setText(String.valueOf(courseDetails.getFee()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getStudent(StudentDTO studentDTO){
         newStudent= studentDTO;
        if(newStudent!=null){
            txtSId.setText(newStudent.getSId());
            txtSName.setText(newStudent.getSName());
        }
    }

    private void loadCourseDetails() throws SQLException, ClassNotFoundException {
        List<String> courses = new CourseDAOImpl().getCourses();
        cmbCourse.getItems().addAll(courses);
    }

    public void getStudentName(String id) throws SQLException, ClassNotFoundException {
        try {
            String name = new StudetDAOImpl().getStudentName(id);
            txtSName.setText(name);
        }catch (Exception e){

        }
    }

    public boolean saveRegister(String regId,String sId, String cId, LocalDate date) {
        try {
            RegisterDTO registerDTO = new RegisterDTO(regId,sId,cId,date);
            return registerBO.registerDetails(registerDTO);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String generateNewId() {
        try {
            return registerBO.generateNewID();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (tblRegistrationDetails.getItems().isEmpty()) {
            return "R001";
        } else {
            String id = getLastDetailId();
            int newDetailId = Integer.parseInt(id.replace("R", "")) + 1;
            return String.format("R%03d", newDetailId);
        }
    }

    private String getLastDetailId() {
        List<RegisterDetailTM> tempDetailList = new ArrayList<>(tblRegistrationDetails.getItems());
        Collections.sort(tempDetailList);
        return tempDetailList.get(tempDetailList.size() - 1).getSId();
    }

    public void moveToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) registrationDetailContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void registerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean b= saveRegister(lblRegId.getText(),txtSId.getText(),txtCourseId.getText(),LocalDate.now());

        String id=lblRegId.getText();
        String Sid=txtSId.getText();
        String SName=txtSName.getText();
        String CId=txtCourseId.getText();
        String CName=cmbCourse.getValue();
        LocalDate date=LocalDate.now();

        if (b) {
            new Alert(Alert.AlertType.INFORMATION, "Register has been done successfully").show();
            tblRegistrationDetails.getItems().add(new RegisterDetailTM(id, Sid, SName, CId, CName, date));
            lblRegId.setText(generateNewId());
        } else {
            new Alert(Alert.AlertType.ERROR, "Register has not been done successfully").show();
        }

    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        try {
            getStudentName(txtSId.getText());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void paidOnAction(ActionEvent actionEvent) {
        boolean isSelect= checkBox.isSelected();
        if (isSelect) {
            regBtn.setDisable(false);
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void searchStore(String value) {

        ObservableList<RegisterDetailTM> obList = FXCollections.observableArrayList();

        List<CustomDTO> detail = registerBO.searchDetail(value);


        /*detail.forEach(e->{
            obList.add(
                    new CustomDTO(e.getRegId(),e.getSId(),e.getSName(),e.getCId(),e.getCName(),e.getRegDate()));
        });*/
        for (CustomDTO temp:detail) {
            obList.add(new RegisterDetailTM(temp.getRegId(),temp.getSId(),temp.getSName(),temp.getCId(),temp.getCName(),temp.getRegDate()));
        }

        tblRegistrationDetails.setItems(obList);
    }

}
