package com.example.tp;

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
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import com.example.tp.Models.*;

import static com.example.tp.HelloApplication.orthophonist;
import static com.example.tp.HomeController.doss;

public class DossierController {
    @FXML
    private TextField textfieldNom;
    @FXML
    private TextField textfieldPrenom;
    @FXML
    private ListView<RendezVous> listviewRDV;
    @FXML
    private ListView<BO> listviewBO;
    @FXML
    private ListView<FicheSuivi> listviewFiches;
    @FXML
    private Button buttonRetour;
    @FXML
    public static BO bo;
    @FXML
    public static FicheSuivi fiche;
    @FXML
    private Button buttonAjouterBO;
    @FXML
    private Button buttonAjouterFiche;
    private ObservableList<FicheSuivi> observableFiches;
    private ObservableList<BO> observableBO;


    HelloApplication m = new HelloApplication();

    public void initialize() {
        // Initialize the fields
        textfieldNom.setText(doss.getPatient().getNom());
        textfieldPrenom.setText(doss.getPatient().getPrenom());

        // Set button actions
        buttonRetour.setOnAction(event -> {
            HelloApplication m = new HelloApplication();
            try {
                m.changeScene("Home.fxml", 900, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Disable selection effect in the ListView
        listviewRDV.setFocusTraversable(false);
        listviewRDV.setSelectionModel(new NoSelectionModel<>());

        // Populate the ListView with RendezVous objects
        ObservableList<RendezVous> observableRDV = FXCollections.observableArrayList(doss.getRendezVous());
        listviewRDV.setItems(observableRDV);

        listviewRDV.setCellFactory(new Callback<>() {
            @Override
            public ListCell<RendezVous> call(ListView<RendezVous> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(RendezVous item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            Label name = new Label("Rendez-Vous" + (getIndex() + 1));
                            Label type;
                            if(item instanceof Consultation)
                            {
                                type = new Label("Consultation");
                            } else if (item instanceof SeanceSuivi) {
                                type = new Label("Seance de Suivi");
                            } else {
                                type = new Label("Atelier de groupe");
                            }

                            TextField Date = new TextField(item.getDate().toString());
                            TextField Heure = new TextField(item.getHeure().toString());

                            // Set fixed widths for Labels
                            name.setPrefWidth(70);
                            type.setPrefWidth(150);
                            Heure.setPrefWidth(150);

                            // Ensure the Date takes up remaining space
                            HBox.setHgrow(Date, Priority.ALWAYS);
                            Date.setMaxWidth(Double.MAX_VALUE);

                            Button supprimerButton = new Button("Supprimer");
                            Button sauvButton = new Button("Sauvegarder");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            sauvButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                // doss.DeleteRDV(getIndex());
                            });

                           sauvButton.setOnAction(event -> {
                                item.setDate(LocalDate.parse(Date.getText()));
                                item.setHeure(LocalTime.parse(Heure.getText()));
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(supprimerButton, sauvButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, type, Date, Heure, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        listviewRDV.refresh();

        // Disable selection effect in the ListView
        listviewBO.setFocusTraversable(false);
        listviewBO.setSelectionModel(new NoSelectionModel<>());

        // Populate the ListView with BO objects
        observableBO = FXCollections.observableArrayList(doss.getBOs());
        listviewBO.setItems(observableBO);

        listviewBO.setCellFactory(new Callback<>() {
            @Override
            public ListCell<BO> call(ListView<BO> listView) {
                return new ListCell<BO>() {
                    @Override
                    protected void updateItem(BO item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            Label name = new Label("BO" + (getIndex() + 1));
                            Label type;
                            if(item instanceof PremierBO) {
                                type = new Label("Premier BO");
                            } else {
                                type = new Label("BO");
                            }

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
                                doss.deleteBO(getIndex());
                            });

                            ModifierButton.setOnAction(event -> {
                                bo=item;
                                try {
                                    m.changeScene("ModifierBO.fxml",900,600);
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
        listviewBO.refresh();
        // Disable selection effect in the ListView
        listviewFiches.setFocusTraversable(false);
        listviewFiches.setSelectionModel(new NoSelectionModel<>());

        // Populate the ListView with BO objects
        observableFiches = FXCollections.observableArrayList(doss.getFicheSuivis());
        listviewFiches.setItems(observableFiches);

        listviewFiches.setCellFactory(new Callback<>() {
            @Override
            public ListCell<FicheSuivi> call(ListView<FicheSuivi> listView) {
                return new ListCell<FicheSuivi>() {
                    @Override
                    protected void updateItem(FicheSuivi item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            Label name = new Label("Fiche" + (getIndex() + 1));
                            Label type = new Label("Fiche de Suivi");

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
                                doss.deleteBO(getIndex());
                            });

                            ModifierButton.setOnAction(event -> {
                                fiche=item;
                                try {
                                    m.changeScene("modifierFiche.fxml",900,600);
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
        listviewFiches.refresh();
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

    public void addBO(){
        BO bo = new BO();
        doss.ajouterBO(bo);
        observableBO.add(bo);
        listviewBO.refresh();
    }
    public void addFiche(){
        FicheSuivi fiche = new FicheSuivi();
        doss.ajouterFicheSuivi(fiche);
        observableFiches.add(fiche);
        listviewFiches.refresh();
    }
}
