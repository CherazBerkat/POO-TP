package com.example.tp;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.time.*;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.io.IOException;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import com.example.tp.Models.*;

import static com.example.tp.HelloApplication.orthophonist;


import static com.example.tp.HelloApplication.orthophonist;

public class ajouterDossierController {
    @FXML
    private TextField textfieldNomA;
    @FXML
    private TextField textfieldNomE;
    @FXML
    private TextField textfieldPreomE;
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
    private Button buttonSauvE;
    @FXML
    private Button buttonSauvA;
    @FXML
    private DatePicker datepickerDateA;
    @FXML
    private DatePicker datepickerDateE;

    public void ajouterEnfant()
    {
        Enfant enfant = new Enfant(textfieldNomE.getText().toString(), textfieldPreomE.getText().toString(), textfieldTelE.getText().toString(), datepickerDateE.getValue(), textfieldLieuE.getText().toString(), textfieldClasseE.getText().toString(), textfieldTel2E.getText().toString());
        Dossier dossier = new Dossier();
        dossier.setPatient(enfant);
        orthophonist.addDossier(dossier);
    }

    public void ajouterAdulte()
    {
        Adult adult = new Adult(textfieldNomA.getText().toString(), textfieldPrenomA.getText().toString(), textfieldTelA.getText().toString(), datepickerDateA.getValue(), textfieldLieuA.getText().toString(), textfieldDiplomeA.getText().toString(), textfieldProfA.getText().toString());
        Dossier dossier = new Dossier();
        dossier.setPatient(adult);
        orthophonist.addDossier(dossier);
    }

}
