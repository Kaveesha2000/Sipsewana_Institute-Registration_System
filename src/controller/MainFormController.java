package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {
    public AnchorPane mainFormContext;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public Label lblError;

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        if(txtPassword.getText().equals("1234") & txtUserName.getText().equalsIgnoreCase("Kaveesha")){
            URL resource = getClass().getResource("../view/DashBoardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) mainFormContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }
        else{
            lblError.setText("Enter correct username or password");
        }
    }

    public void goToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }
}
