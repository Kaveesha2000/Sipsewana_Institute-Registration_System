package controller;

import dao.impl.CourseDAOImpl;
import dao.impl.StudetDAOImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DashBoardFormController {
    public Label totCourses;
    public Label totStudents;
    public AnchorPane dashBoardContext;
    public Label lblDate;
    public Label lblTime;

    public void initialize(){
        loadDateAndTime();
        try {
            setCount();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
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

    public void moveToRegisterFormOnActrion(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RegisterDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashBoardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadDateAndTime() {
        // load Date
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        // load Time
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();

            String state = null;
            if (currentTime.getHour() >= 12) {
                state = "PM";
            } else {
                state = "AM";
            }
            lblTime.setText("" + String.format("%02d",currentTime.getHour()) + ":" + String.format("%02d", currentTime.getMinute()) + ":" + String.format("%02d", currentTime.getSecond())+" "+state);

        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void setCount() throws SQLException, ClassNotFoundException {
        totStudents.setText(String.valueOf(new StudetDAOImpl().studentCount()));
        totCourses.setText(String.valueOf(new CourseDAOImpl().courseCount()));
    }
}
