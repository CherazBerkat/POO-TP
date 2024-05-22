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
    private Button signUp;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    public void userSignUp(ActionEvent event)throws IOException {
        signUp();
    }

    public void checkLogin() throws IOException {
        HelloApplication m = new HelloApplication();
        if(username.getText().toString().equals(orthophonist.getUserName()) && password.getText().toString().equals(orthophonist.getPasswd())) {
            wrongLogIn.setText("Success!");

            m.changeScene("Home.fxml",900,600);
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }

        else {
            wrongLogIn.setText("Wrong username or password!");
        }
    }

    public void signUp () throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("SignUp.fxml",400,500);
    }

}
