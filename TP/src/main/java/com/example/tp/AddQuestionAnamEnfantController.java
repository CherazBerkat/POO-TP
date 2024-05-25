package com.example.tp;

import com.example.tp.Models.QuestionAnamEnfant;
import com.example.tp.Models.TypeAnamneseEnfant;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import static com.example.tp.HomeController.anam;

public class AddQuestionAnamEnfantController {
    @FXML
    private TextArea text;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private Label label;
    private String[] choices = new String[]{"ANTECEDENTS FAMILIAUX",
            "CARACTERE ET COMPORTEMENT","DEVELOPPEMENT LANGAGIER", "DEVELOPPEMENT PSYCHOMOTEUR",
            "STRUCTURE FAMILIALE","DYNAMIQUE FAMILIALE","CONDITIONS NATALES"};

    public void initialize() {
        type.getItems().addAll(choices);

        // Clear label when text area or choice box is focused
        text.focusedProperty().addListener((observable, oldValue, newValue) -> {
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
        if (text.getText().isEmpty() || type.getValue() == null) {
            // If any field is empty, show error message in red
            label.setText("Veuillez remplir tous les champs");
            label.setStyle("-fx-text-fill: red;");
        } else {
            // If all fields are filled, save and show success message in green
            anam.ajouterQuestion(new QuestionAnamEnfant(text.getText(), TypeAnamneseEnfant.valueOf(type.getValue().replace(" ",""))));
            label.setText("Question ajoutée avec succès");
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
