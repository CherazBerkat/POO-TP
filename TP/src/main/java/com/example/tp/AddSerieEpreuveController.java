package com.example.tp;

import com.example.tp.Models.SerieExo;
import com.example.tp.Models.SerieQuestion;
import com.example.tp.Models.Test;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.util.List;

import static com.example.tp.ModifierEpreuveController.isSQuest;
import static com.example.tp.HelloApplication.orthophonist;
import static com.example.tp.ModifierBOController.ep;

public class AddSerieEpreuveController {
    @FXML
    private Label label;
    @FXML
    private ChoiceBox<Test> serie;

    public void initialize() {
        List<? extends Test> series;
        if (isSQuest) {
            series = orthophonist.getSerieQuestions();
        } else {
            series = orthophonist.getSerieExos();
        }

        // Set the StringConverter to display the name of the series
        serie.setConverter(new StringConverter<>() {
            @Override
            public String toString(Test test) {
                return test != null ? test.getNom() : "";
            }

            @Override
            public Test fromString(String string) {
                return null; // No need to implement
            }
        });

        serie.getItems().addAll(series);
        serie.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                label.setText("");
            }
        });
    }

    public void save() {
        Test selectedSerie = serie.getValue();
        if (selectedSerie == null) {
            // If no series is selected, show error message in red
            label.setText("Veuillez choisir une série");
            label.setStyle("-fx-text-fill: red;");
        } else {
            // If a series is selected, save and show success message in green
            if (isSQuest && selectedSerie instanceof SerieQuestion) {
                ep.ajouterSerieQuestions((SerieQuestion) selectedSerie);
            } else if (!isSQuest && selectedSerie instanceof SerieExo) {
                ep.ajouterSerieExercices((SerieExo) selectedSerie);
            }

            label.setText("Serie ajouté avec succès");
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
