package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
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
import view.tdm.CourseTM;
import view.tdm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseFormController {
    public Button btnSave;
    public AnchorPane courseContext;
    public JFXTextField txtCName;
    public JFXTextField txtFee;
    public JFXTextField txtDuration;
    public Label lblCId;
    public JFXTextField txtSearchBar;
    public TableView<CourseTM> tblCourse;
    public TableColumn colCourseId;
    public TableColumn colName;
    public TableColumn colDuration;
    public TableColumn colFee;


    private final CourseBO courseBO = (CourseBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.COURSE);

    public void initialize(){

        lblCId.setText(generateNewId());
        //lblCId.setDisable(true);

        colCourseId.setCellValueFactory(new PropertyValueFactory<>("CId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("CName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("Fee"));

        loadAllCourses();
        //btnSave.setDisable(true);

        tblCourse.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lblCId.setText(newValue.getCId());
                txtCName.setText(newValue.getCName());
                txtDuration.setText(newValue.getDuration());
                txtFee.setText(String.valueOf(newValue.getFee()));
                lblCId.setDisable(true);
                btnSave.setDisable(true);
            }
        });
    }

    private void loadAllCourses() {
        tblCourse.getItems().clear();
        try {
            ArrayList<CourseDTO> allCourses = courseBO.getAllCourses();
            for (CourseDTO course : allCourses) {
                tblCourse.getItems().add(new CourseTM(course.getCId(),course.getCName(),course.getDuration(),course.getFee()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private String generateNewId() {
        try {
            return courseBO.generateNewID();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (tblCourse.getItems().isEmpty()) {
            return "C001";
        } else {
            String id = getLastStudentId();
            int newCustomerId = Integer.parseInt(id.replace("C", "")) + 1;
            return String.format("C%03d", newCustomerId);
        }
    }

    private String getLastStudentId() {
        List<CourseTM> tempCourseList = new ArrayList<>(tblCourse.getItems());
        Collections.sort(tempCourseList);
        return tempCourseList.get(tempCourseList.size() - 1).getCId();
    }

    boolean exitsCourse(String id) throws SQLException, ClassNotFoundException {
        return courseBO.ifCourseExist(id);
    }

    private void clear() {
        txtCName.clear();
        txtFee.clear();
        txtDuration.clear();
    }

    public void moveToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) courseContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String id=lblCId.getText();
        String name=txtCName.getText();
        String duration=txtDuration.getText();
        double fee= Double.parseDouble(txtFee.getText());

        try {
            if (exitsCourse(id)) {
                new Alert(Alert.AlertType.ERROR, id + " Already Exists").show();
            }
            else{
                new Alert(Alert.AlertType.CONFIRMATION,  "Saved...!").show();

                clear();
                CourseDTO courseDTO = new CourseDTO(id, name, duration, fee);
                courseBO.addCourse(courseDTO);
                tblCourse.getItems().add(new CourseTM(id, name, duration, fee));
                lblCId.setText(generateNewId());
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the course " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String id=lblCId.getText();
        String name=txtCName.getText();
        String duration=txtDuration.getText();
        double fee= Double.parseDouble(txtFee.getText());

        try {
            if (!exitsCourse(id)) {
                new Alert(Alert.AlertType.ERROR, id + " There is no such course associated with the id "+id).show();
            }
            else {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated...!").show();
                clear();
                CourseDTO courseDTO = new CourseDTO(id, name, duration, fee);
                courseBO.updateCourse(courseDTO);
                lblCId.setText(generateNewId());
                btnSave.setDisable(false);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to update the course " + id + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        CourseTM selectedCourse = tblCourse.getSelectionModel().getSelectedItem();
        selectedCourse.setCName(name);
        selectedCourse.setDuration(duration);
        selectedCourse.setFee(fee);
        tblCourse.refresh();
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id = tblCourse.getSelectionModel().getSelectedItem().getCId();
        try {
            if (!exitsCourse(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such course associated with the id " + id).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted...!").show();
                courseBO.deleteCourse(id);
                tblCourse.getItems().remove(tblCourse.getSelectionModel().getSelectedItem());
                tblCourse.getSelectionModel().clearSelection();
                clear();
                lblCId.setText(generateNewId());
                btnSave.setDisable(false);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the course " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
