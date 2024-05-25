package com.example.tp;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Map;
import java.time.*;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import com.example.tp.Models.*;

import static com.example.tp.DossierController.bo;
import static com.example.tp.HelloApplication.orthophonist;
import static com.example.tp.HomeController.doss;

public class ModifierBOController {
    @FXML
    private TextField textfieldProjet;
    @FXML
    private ListView<Trouble> listviewDiag;
    @FXML
    private ListView<EpreuveClinique> listviewEpreuve;
    @FXML
    private Button buttonRetour;
    private ObservableList<Trouble> observableDiag;
    private ObservableList<EpreuveClinique> observableEpreuve;

    private static EpreuveClinique ep;

    private HelloApplication m= new HelloApplication();

    public void initialize() {
        textfieldProjet.setText(bo.getProjetTherapeutique());

        // Set button actions
        buttonRetour.setOnAction(event -> {
            HelloApplication m = new HelloApplication();
            try {
                m.changeScene("Home.fxml", 900, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //************************list trouble de diagnostic********************************
        // Disable selection effect in the ListView
        listviewDiag.setFocusTraversable(false);
        listviewDiag.setSelectionModel(new ModifierBOController.NoSelectionModel<>());

        // Populate the ListView with Trouble objects
        observableDiag = FXCollections.observableArrayList(bo.getDiagnostic().getTroubles());
        listviewDiag.setItems(observableDiag);

        listviewDiag.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Trouble> call(ListView<Trouble> listView) {
                return new ListCell<Trouble>() {
                    @Override
                    protected void updateItem(Trouble item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            Label name = new Label("Trouble" + (getIndex() + 1));
                            TextField type = new TextField(item.getType().toString());
                            TextField Nom = new TextField(item.getNom().toString());

                            //Set fixed widths for Labels
                            name.setPrefWidth(70);
                            Nom.setPrefWidth(150);
                            // Ensure the type takes up remaining space
                            HBox.setHgrow(type, Priority.ALWAYS);
                            type.setMaxWidth(Double.MAX_VALUE);

                            Button supprimerButton = new Button("Supprimer");
                            Button SauvButton = new Button("Sauvgarder");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            SauvButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            //Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                bo.getDiagnostic().deleteTrouble(getIndex());
                            });

                            SauvButton.setOnAction(event -> {
                                bo.getDiagnostic().getTrouble(getIndex()).setNom(Nom.getText());
                                bo.getDiagnostic().getTrouble(getIndex()).setType(TypeTrouble.valueOf(type.getText()));
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(supprimerButton, SauvButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, type, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        listviewDiag.refresh();

    //************************list Epreuves********************************
    // Disable selection effect in the ListView
        listviewEpreuve.setFocusTraversable(false);
        listviewEpreuve.setSelectionModel(new ModifierBOController.NoSelectionModel<>());

    // Populate the ListView with Epreuve objects
    observableEpreuve = FXCollections.observableArrayList(bo.getEpreuveClinique());
        listviewEpreuve.setItems(observableEpreuve);

        listviewEpreuve.setCellFactory(new Callback<>() {
        @Override
        public ListCell<EpreuveClinique> call(ListView<EpreuveClinique> listView) {
            return new ListCell<EpreuveClinique>() {
                @Override
                protected void updateItem(EpreuveClinique item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null && !empty) {
                        HBox hBox = new HBox(20);
                        hBox.setPrefHeight(50);
                        hBox.setAlignment(Pos.CENTER_LEFT);

                        Label name = new Label("Epreuve" + (getIndex() + 1));
                        Label type= new Label("Epreuve Clinique");

                        //Set fixed widths for Labels
                        name.setPrefWidth(70);
                        // Ensure the type takes up remaining space
                        HBox.setHgrow(type, Priority.ALWAYS);
                        type.setMaxWidth(Double.MAX_VALUE);

                        Button supprimerButton = new Button("Supprimer");
                        Button ModifierButton = new Button("Modifier");

                        // Styling buttons
                        supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                        ModifierButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                        //Set button actions
                        supprimerButton.setOnAction(event -> {
                            getListView().getItems().remove(item);
                            bo.deleteEpreuveClinique(getIndex());
                        });

                        ModifierButton.setOnAction(event -> {
                            ep=item;
                            try {
                                m.changeScene("ModifierEpreuve.fxml",900,600);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        // Add hover effect
                        setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                        setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                        // Create a nested HBox for buttons
                        HBox buttonsBox = new HBox(20);
                        buttonsBox.getChildren().addAll(supprimerButton, ModifierButton);
                        buttonsBox.setAlignment(Pos.CENTER_LEFT);

                        // Add elements to outer HBox
                        hBox.getChildren().addAll(name, type, buttonsBox);
                        setGraphic(hBox);
                    } else {
                        setGraphic(null);
                    }
                }
            };
        }
    });
        listviewEpreuve.refresh();
}

    // Custom NoSelectionModel class to disable selection
    private static class NoSelectionModel<T> extends MultipleSelectionModel<T> {
        @Override
        public ObservableList<Integer> getSelectedIndices() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public ObservableList<T> getSelectedItems() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public void selectIndices(int index, int... indices) {
        }

        @Override
        public void selectAll() {
        }

        @Override
        public void selectFirst() {
        }

        @Override
        public void selectLast() {
        }

        @Override
        public void clearAndSelect(int index) {
        }

        @Override
        public void select(int index) {
        }

        @Override
        public void select(T obj) {
        }

        @Override
        public void clearSelection(int index) {
        }

        @Override
        public void clearSelection() {
        }

        @Override
        public boolean isSelected(int index) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public void selectPrevious() {
        }

        @Override
        public void selectNext() {
        }
    }

    public void saveProjet()
    {
        bo.setProjetTherapeutique(textfieldProjet.getText());
    }

    public void addTrouble(){
        Trouble t = new Trouble("", TypeTrouble.COGNITIFS);
        bo.getDiagnostic().ajouterTrouble(t);
        observableDiag.add(t);
        listviewDiag.refresh();
    }
    public void addFiche(){
        EpreuveClinique e = new EpreuveClinique();
        bo.ajouterEpreuveClinique(e);
        observableEpreuve.add(e);
        listviewEpreuve.refresh();
    }
}
