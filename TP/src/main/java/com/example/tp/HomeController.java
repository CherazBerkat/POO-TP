package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import java.io.IOException;

import static com.example.tp.HelloApplication.orthophonist;

public class HomeController {
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
    @FXML
    private Label label;
    @FXML
    private Label label1;
    private Timeline timeline;

    @FXML
    public void initialize() {
        // Create a timeline
        timeline = new Timeline();
        username.setText(orthophonist.getUserName());
        nom.setText(orthophonist.getNom());
        prenom.setText(orthophonist.getPrenom());
        adr.setText(orthophonist.getAdr());
        email.setText(orthophonist.getMail());
        tel.setText(orthophonist.getTel());
        passwd.setText(orthophonist.getPasswd());
        label1.setText(orthophonist.getUserName());
        // Add a keyframe to clear the label text after a short delay
        KeyFrame clearFrame = new KeyFrame(Duration.seconds(1), e -> label.setText(""));
        timeline.getKeyFrames().add(clearFrame);
    }

    public void updateInfos(ActionEvent event)throws IOException {
      majInfos();
    }

    public void majInfos(){
        label.setText("Data updated!");
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(4), e -> {
            label.setText("");
            // Stop the timeline
            timeline.stop();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        orthophonist.setMail(email.getText().toString());
        orthophonist.setNom(nom.getText().toString());
        orthophonist.setPasswd(passwd.getText().toString());
        orthophonist.setPrenom(prenom.getText().toString());
        orthophonist.setTel(tel.getText().toString());
        orthophonist.setUserName(username.getText().toString());
        orthophonist.setAdr(adr.getText().toString());
        label1.setText(orthophonist.getUserName());
        orthophonist.affichInfo();
    }

    public  void signOut ()throws IOException{
        HelloApplication m = new HelloApplication();
        m.changeScene("logIN.fxml",400,500);
        orthophonist.save();
        System.out.println("Signed Out");
        System.out.println("data saved");
    }
}
