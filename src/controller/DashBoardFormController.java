package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {
    public Label totCourses;
    public Label totStudents;
    public AnchorPane dashBoardContext;

    public void logOutOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void moveToCourseFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CourseForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashBoardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void moveToStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashBoardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
