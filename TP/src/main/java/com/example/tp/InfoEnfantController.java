package com.example.tp;
import com.example.tp.Models.Enfant;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.tp.HomeController.doss;

public class InfoEnfantController {
    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField lieu;
    @FXML
    TextField classe;
    @FXML
    TextField tel2;
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
        tel2.setText(((Enfant)doss.getPatient()).getTel2());
        classe.setText(((Enfant)doss.getPatient()).getClasse());
    }

    public void save(){
        doss.getPatient().setNom(nom.getText().toString());
        doss.getPatient().setPrenom(prenom.getText().toString());
        doss.getPatient().setDateNaissance(date.getValue());
        doss.getPatient().setLieuNaissance(lieu.getText().toString());
        doss.getPatient().setTel(tel.getText().toString());
        ((Enfant)doss.getPatient()).setTel2(tel2.getText().toString());
        ((Enfant)doss.getPatient()).setClasse(classe.getText().toString());
    }

    public void retour () throws IOException {
        HelloApplication m=new HelloApplication();
        m.changeScene("Home.fxml",900,600);
    }
}
