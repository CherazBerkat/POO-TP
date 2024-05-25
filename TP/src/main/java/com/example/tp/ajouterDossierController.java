package com.example.tp;


import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import com.example.tp.Models.*;
import javafx.util.Duration;

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

    @FXML
    private Label label;
    @FXML
    private Label label2;


    public void ajouterEnfant() throws IOException {
        if (textfieldNomE.getText().isEmpty() || textfieldPrenomE.getText().isEmpty() || textfieldTelE.getText().isEmpty() ||
                datepickerDateE.getValue() == null || textfieldLieuE.getText().isEmpty() || textfieldClasseE.getText().isEmpty() || textfieldTel2E.getText().isEmpty()) {
            label.setText("Veuillez remplir tous les champs");
            label.setStyle("-fx-text-fill: red;");

        } else {
            Enfant enfant = new Enfant(textfieldNomE.getText(), textfieldPrenomE.getText(), textfieldTelE.getText(), datepickerDateE.getValue(), textfieldLieuE.getText(), textfieldClasseE.getText(), textfieldTel2E.getText());
            Dossier dossier = new Dossier();
            dossier.setPatient(enfant);
            orthophonist.addDossier(dossier);
            label.setText("Dossier ajoutée avec succès");
            label.setStyle("-fx-text-fill: green;");
            // Reset label after 6 seconds
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(6));
            visiblePause.setOnFinished(event -> {
                label.setText("");
                label.setStyle(""); // Clear text color style
            });
        }
    }

    public void ajouterAdulte() throws IOException {

        if(textfieldNomA.getText().isEmpty()|| textfieldPrenomA.getText().isEmpty()|| textfieldTelA.getText().isEmpty()|| datepickerDateA.getValue()==null|| textfieldLieuA.getText().isEmpty()|| textfieldDiplomeA.getText().isEmpty()|| textfieldProfA.getText().isEmpty()){
            label2.setText("Veuillez remplir tous les champs");
            label2.setStyle("-fx-text-fill: red;");
        }else {
            Adult adult = new Adult(textfieldNomA.getText(), textfieldPrenomA.getText(), textfieldTelA.getText(), datepickerDateA.getValue(), textfieldLieuA.getText(), textfieldDiplomeA.getText(), textfieldProfA.getText());
            Dossier dossier = new Dossier();
            dossier.setPatient(adult);
            orthophonist.addDossier(dossier);
            label2.setText("Dossier ajoutée avec succès");
            label2.setStyle("-fx-text-fill: green;");
            // Reset label after 6 seconds
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(6));
            visiblePause.setOnFinished(event -> {
                label2.setText("");
                label2.setStyle(""); // Clear text color style
            });
        }
    }

}
