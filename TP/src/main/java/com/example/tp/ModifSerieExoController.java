package com.example.tp;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.Callback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import com.example.tp.Models.*;

import static com.example.tp.HomeController.anam;
import static com.example.tp.HomeController.sExo;
public class ModifSerieExoController {
    @FXML
    private ListView<Exo> listE;
    @FXML
    private HBox upHbox=new HBox(30);;
    @FXML
    public void initialize() {
        //************************************************* The upper Section ******************************************//
        upHbox.setPrefHeight(100);
        upHbox.setAlignment(Pos.CENTER_LEFT);
        upHbox.setStyle("-fx-padding: 0 20;");

        TextField titre = new TextField(sExo.getNom());
        titre.setPrefWidth(200);
        titre.setStyle("-fx-text-fill:#48efa6; -fx-font-weight: 800; -fx-font-size:18;");

        TextField capacite = new TextField(sExo.getCapacite());
        capacite.setPrefWidth(400);
        capacite.setStyle("-fx-font-weight: 800; -fx-font-size:18;");

        Button saveButton=new Button("sauvegarder");
        saveButton.setStyle("-fx-background-color:#48efa6; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:18;");
        saveButton.prefWidth(400);
        saveButton.prefHeight(10);
        // Set button actions
        saveButton.setOnAction(event -> {
           sExo.setNom(titre.getText().toString());
           sExo.setCapacite(capacite.getText().toString());
        });

        Button retourButton = new Button("retour");
        retourButton.setStyle("-fx-background-color:#48efa6; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:18;");
        retourButton.prefWidth(350);
        retourButton.prefHeight(10);
        // Set button actions
        retourButton.setOnAction(event -> {
            HelloApplication m = new HelloApplication();
            try {
                m.changeScene("Home.fxml", 900, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Create a nested HBox for buttons
        HBox buttonsBox = new HBox(20);
        buttonsBox.getChildren().addAll(retourButton,saveButton);
        buttonsBox.setAlignment(Pos.CENTER_LEFT);

        // Add a region to create space between name and buttons
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
       // Add a fixed-width spacer between the titre and capacite
        Region fixedSpacer = new Region();
        fixedSpacer.setPrefWidth(20);

        upHbox.getChildren().addAll(titre,fixedSpacer,capacite, spacer, buttonsBox);
        //************************************************* La list des Exos *****************************************//
        // Disable selection effect in the ListView
        listE.setFocusTraversable(false);
        listE.setSelectionModel(new ModifSerieExoController.NoSelectionModel<>());

        ObservableList<Exo> observableExos = FXCollections.observableArrayList(sExo.getExos());
        listE.setItems(observableExos);

        listE.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Exo> call(ListView<Exo> listView) {
                return new ListCell<Exo>() {
                    @Override
                    protected void updateItem(Exo item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            Label name = new Label("Exercice" + (getIndex() + 1));
                            TextField consigne= new TextField(item.getConsigne());
                            TextField materiel= new TextField(item.getMateriel());


                            // Set fixed widths for Labels
                            name.setPrefWidth(70);
                            materiel.setPrefWidth(200);

                            // Ensure the TextField takes up remaining space
                            HBox.setHgrow(consigne, Priority.ALWAYS);
                            consigne.setMaxWidth(Double.MAX_VALUE);

                            Button supprimerButton = new Button("Supprimer");
                            Button sauvButton = new Button("Sauvegarder");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            sauvButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                sExo.deleteExoIndx(getIndex());
                            });

                            sauvButton.setOnAction(event -> {
                                item.setConsigne(consigne.getText().toString());
                                item.setMateriel(materiel.getText().toString());
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(supprimerButton,sauvButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, materiel,consigne, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        listE.refresh();
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

}
