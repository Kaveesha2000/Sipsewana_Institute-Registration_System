package controller;

import bo.BOFactory;
import bo.custom.RegisterBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.impl.CourseDAOImpl;
import dao.impl.StudetDAOImpl;
import dto.RegisterDTO;
import dto.StudentDTO;
import entity.Course;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tdm.RegisterTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class RegisterDetailsFormController {
    public AnchorPane registrationDetailContext;
    public TableView<RegisterTM> tblRegistrationDetails;
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

    StudentDTO newStudent;

    private final RegisterBO registerBO = (RegisterBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REGISTERDETAILS);

    public void initialize(){
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

    public void moveToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) registrationDetailContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void registerOnAction(ActionEvent actionEvent) {
        boolean b= saveRegister(lblRegId.getText(),txtSId.getText(),txtCourseId.getText(),LocalDate.now());

        if (b) {
            new Alert(Alert.AlertType.INFORMATION, "Register has been done successfully").show();
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

    public void getStudentName(String id) throws SQLException, ClassNotFoundException {
        try {
            String name = new StudetDAOImpl().getStudentName(id);
            txtSName.setText(name);
        }catch (Exception e){

        }
    }


    //=========================================
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
}
