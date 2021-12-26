package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StudentFormController {
    public Button btnSave;
    public AnchorPane studentContext;
    public Label lblSId;
    public JFXTextField txtSName;
    public JFXTextField txtDOB;
    public JFXTextField txtAddress;
    public JFXTextField txtNIC;
    public JFXTextField txtPhoneNo;
    public TableView tblStudent;
    public JFXComboBox cmbCourse;
    public JFXTextField txtSearchBar;
    public TableColumn colRegNo;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDOB;
    public TableColumn colNIC;
    public TableColumn colPhoneNo;
    public TableColumn colCourse;

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void moveToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
