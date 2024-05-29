package com.example.tp;

import com.example.tp.Models.Adult;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.tp.HomeController.doss;

public class InfoAdultController {
    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField lieu;
    @FXML
    TextField prof;
    @FXML
    TextField diplome;
    @FXML
    TextField tel;
    @FXML
    DatePicker date;

    public void initialize() {
     nom.setText(doss.getPatient().getNom());
     prenom.setText(doss.getPatient().getPrenom());
     date.setValue(doss.getPatient().getDateNaissance());
     lieu.setText(doss.getPatient().getLieuNaissance());
     tel.setText(doss.getPatient().getTel());
     diplome.setText(((Adult)doss.getPatient()).getDiplome());
     prof.setText(((Adult)doss.getPatient()).getProf());
    }

    public void save(){
        doss.getPatient().setNom(nom.getText().toString());
        doss.getPatient().setPrenom(prenom.getText().toString());
        doss.getPatient().setDateNaissance(date.getValue());
        doss.getPatient().setLieuNaissance(lieu.getText().toString());
        doss.getPatient().setTel(tel.getText().toString());
        ((Adult)doss.getPatient()).setDiplome(diplome.getText().toString());
        ((Adult)doss.getPatient()).setProf(prof.getText().toString());
    }

    public void retour () throws IOException {
        HelloApplication m=new HelloApplication();
        m.changeScene("Home.fxml",900,600);
    }




}
