package com.example.tp;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import static com.example.tp.ModifSerieQuestionController.qcu;

public class AddPropoController {
    @FXML
    private TextArea choix;
    @FXML
    private Label label;
    public void initialize() {
        choix.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                label.setText("");
            }
        });
    }

    public void save() {
        if (choix.getText().isEmpty()) {
            // If any field is empty, show error message in red
            label.setText("Veuillez remplir le text de choix");
            label.setStyle("-fx-text-fill: red;");
        } else {
            // If all fields are filled, save and show success message in green
            qcu.addPropo(choix.getText().toString(),false);
            label.setText("Choix ajoutée avec succès");
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
