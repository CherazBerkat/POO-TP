package com.example.tp;

import com.example.tp.Models.*;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

import static com.example.tp.DossierController.premierBO;
import static com.example.tp.HelloApplication.orthophonist;
import static com.example.tp.HomeController.doss;
import static com.example.tp.ModifierBOController.ep;
import static com.example.tp.ModifierEpreuveController.isSQuest;

public class addAnamController {
    @FXML
    private Button buttonSauv;
    @FXML
    private Label label;
    @FXML
    private ChoiceBox<String> choiceAnam;
    private List<? extends Anamnese> anamneses;

    public void initialize() {
        if (doss.getPatient() instanceof Adult) {
            anamneses = orthophonist.getAnamnesesAdult();
        } else {
            anamneses = orthophonist.getAnamnesesEnfant();
        }

        // Populate the ChoiceBox with the anamneses
        choiceAnam.getItems().addAll(generateAnamnesesList());

        // Set the StringConverter to display the name of the anamnese with its index
        choiceAnam.setConverter(new StringConverter<>() {
            @Override
            public String toString(String anamDisplay) {
                return anamDisplay;
            }

            @Override
            public String fromString(String string) {
                return string; // No need to implement for this case
            }
        });
    }

    private List<String> generateAnamnesesList() {
        List<String> anamnesesList = new ArrayList<>();
        for (int i = 0; i < anamneses.size(); i++) {
            anamnesesList.add("anamnese" + (i + 1));
        }
        return anamnesesList;
    }

    public void save() {
        String selectedAnam = choiceAnam.getValue();
        if (selectedAnam == null) {
            // If no anamnese is selected, show error message in red
            label.setText("Veuillez choisir une anamnese");
            label.setStyle("-fx-text-fill: red;");
        } else {
            // If an anamnese is selected, save and show success message in green
            premierBO.setAnamnese((Anamnese) anamneses.get(choiceAnam.getSelectionModel().getSelectedIndex()));
            label.setText("Anamnese ajouté avec succès");
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
