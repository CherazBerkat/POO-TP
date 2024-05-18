package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.tp.HelloApplication.orthophonist;
public class SignUpController {
    @FXML
    private Button SignUp;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adr;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private PasswordField passwd;
    public void signUp (ActionEvent event) throws IOException{
        userSignUp();
    }
    public void userSignUp() throws IOException{
        if(username.getText().isEmpty() || passwd.getText().isEmpty() || email.getText().isEmpty()||
                nom.getText().isEmpty() || prenom.getText().isEmpty() ||
                tel.getText().isEmpty() || username.getText().isEmpty() || adr.getText().isEmpty()) {
            wrongLogIn.setText("Please fill all your data.");
        }else{
        HelloApplication m = new HelloApplication();
        orthophonist.setMail(email.getText().toString());
        orthophonist.setNom(nom.getText().toString());
        orthophonist.setPasswd(passwd.getText().toString());
        orthophonist.setPrenom(prenom.getText().toString());
        orthophonist.setTel(tel.getText().toString());
        orthophonist.setUserName(username.getText().toString());
        orthophonist.setAdr(adr.getText().toString());
        orthophonist.affichInfo();
        m.changeScene("Home.fxml",600,400);
        }

    }
}
