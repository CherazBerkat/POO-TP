package com.example.tp;

import com.example.tp.Models.SerieExo;
import com.example.tp.Models.SerieQuestion;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import static com.example.tp.HomeController.isSQuest;
import static com.example.tp.HelloApplication.orthophonist;

public class AddSerieController {
    @FXML
    private TextField nom;
    @FXML
    private TextField capacite;
    @FXML
    private Label label;
    public void initialize() {
        nom.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                label.setText("");
            }
        });
        capacite.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                label.setText("");
            }
        });

    }

    public void save() {
        if (nom.getText().isEmpty() || capacite.getText().isEmpty()) {
            // If any field is empty, show error message in red
            label.setText("Veuillez remplir tous les champs");
            label.setStyle("-fx-text-fill: red;");
        } else {
            // If all fields are filled, save and show success message in green
            if(isSQuest)
                orthophonist.addSerieQuestions(new SerieQuestion(nom.getText().toString(),capacite.getText().toString()));
            else
                orthophonist.addSerieExos(new SerieExo(nom.getText().toString(),capacite.getText().toString()));
            label.setText("Serie ajoutée avec succès");
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
