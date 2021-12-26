package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegisterDetailsFormController {
    public AnchorPane registrationDetailContext;
    public TableView tblRegistrationDetails;
    public TableColumn colSId;
    public TableColumn colSName;
    public TableColumn colCId;
    public TableColumn colCName;
    public TableColumn colRegDate;
    public JFXTextField txtSearchBar;

    public void moveToHome(MouseEvent mouseEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
