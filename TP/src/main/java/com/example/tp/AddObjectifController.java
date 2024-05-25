package com.example.tp;

import com.example.tp.Models.Objectif;
import com.example.tp.Models.QuestionAnamAdult;
import com.example.tp.Models.TypeAnamneseAdulte;
import com.example.tp.Models.TypeObjectif;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import static com.example.tp.DossierController.fiche;

public class AddObjectifController {
    @FXML
    private TextField nom;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private Label label;
    private String[] choices=new String[]{"LONG TERME","MOYEN TERME","COURT TERME"};

    public void initialize() {
        type.getItems().addAll(choices);

        // Clear label when text area or choice box is focused
        nom.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                label.setText("");
            }
        });

        type.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                label.setText("");
            }
        });


    }

    public void save() {
        if (nom.getText().isEmpty() || type.getValue() == null) {
            // If any field is empty, show error message in red
            label.setText("Veuillez remplir tous les champs");
            label.setStyle("-fx-text-fill: red;");
        } else {
            // If all fields are filled, save and show success message in green
            fiche.ajouterObjectif(new Objectif(nom.getText().toString(), TypeObjectif.valueOf(type.getValue().toString().replace(" ","").toUpperCase())));
            label.setText("Objectif ajoutée avec succès");
            label.setStyle("-fx-text-fill: green;");

            // Reset label after 6 seconds
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(6));
            visiblePause.setOnFinished(event -> {
                label.setText("");
                label.setStyle(""); // Clear text color style
            });
            visiblePause.play();
        }
    }
}
