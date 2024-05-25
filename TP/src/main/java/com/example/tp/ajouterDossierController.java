package com.example.tp;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import com.example.tp.Models.*;

import static com.example.tp.HelloApplication.orthophonist;

public class ajouterDossierController {
    @FXML
    private TextField textfieldNomA;
    @FXML
    private TextField textfieldNomE;
    @FXML
    private TextField textfieldPrenomE;
    @FXML
    private TextField textfieldPrenomA;
    @FXML
    private TextField textfieldTelA;
    @FXML
    private TextField textfieldTelE;
    @FXML
    private TextField textfieldTel2E;
    @FXML
    private TextField textfieldLieuA;
    @FXML
    private TextField textfieldLieuE;
    @FXML
    private TextField textfieldProfA;
    @FXML
    private TextField textfieldDiplomeA;
    @FXML
    private TextField textfieldClasseE;
    @FXML
    private DatePicker datepickerDateA;
    @FXML
    private DatePicker datepickerDateE;
    HelloApplication m = new HelloApplication();


    public void ajouterEnfant() throws IOException {
        Enfant enfant = new Enfant(textfieldNomE.getText(), textfieldPrenomE.getText(), textfieldTelE.getText(), datepickerDateE.getValue(), textfieldLieuE.getText(), textfieldClasseE.getText(), textfieldTel2E.getText());
        Dossier dossier = new Dossier();
        dossier.setPatient(enfant);
        orthophonist.addDossier(dossier);
        try {
            m.changeScene("Home.fxml",900,600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ajouterAdulte() throws IOException {
        Adult adult = new Adult(textfieldNomA.getText(), textfieldPrenomA.getText(), textfieldTelA.getText(), datepickerDateA.getValue(), textfieldLieuA.getText(), textfieldDiplomeA.getText(), textfieldProfA.getText());
        Dossier dossier = new Dossier();
        dossier.setPatient(adult);
        orthophonist.addDossier(dossier);
        try {
            m.changeScene("Home.fxml",900,600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
