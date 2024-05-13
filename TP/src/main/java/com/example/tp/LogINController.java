package com.example.tp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import static com.example.tp.HelloApplication.orthophonist;

public class LogINController {
    @FXML
    private Button login;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        HelloApplication m = new HelloApplication();
        if(username.getText().toString().equals(orthophonist.getUserNAme()) && password.getText().toString().equals(orthophonist.getPasswd())) {
            wrongLogIn.setText("Success!");

            m.changeScene("Home.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }

        else {
            wrongLogIn.setText("Wrong username or password!");
        }
    }


}