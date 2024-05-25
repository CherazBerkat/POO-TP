package com.example.tp;

import com.example.tp.Models.Exo;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import static com.example.tp.HomeController.sExo;

public class AddExoCntroller {
    @FXML
    private TextArea consigne;
    @FXML
    private TextField materiel;
    @FXML
    private Label label;
    public void save() {
        if (consigne.getText().isEmpty() || materiel.getText().isEmpty()) {
            // If any field is empty, show error message in red
            label.setText("Veuillez remplir tous les champs");
            label.setStyle("-fx-text-fill: red;");
        } else {
            // If all fields are filled, save and show success message in green
            sExo.addExo(new Exo(consigne.getText().toString(),materiel.getText().toString()));
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
