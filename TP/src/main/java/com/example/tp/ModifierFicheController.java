package com.example.tp;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
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

import static com.example.tp.DossierController.fiche;


public class ModifierFicheController {
    @FXML
    private ListView<Objectif> listO;
    @FXML
    private HBox upHbox=new HBox(20);;
    @FXML
    public void initialize() {
        //************************************************* The upper Section ******************************************//
        upHbox.setPrefHeight(100);
        upHbox.setAlignment(Pos.CENTER_LEFT);
        upHbox.setStyle("-fx-padding: 0 20;");

        Label titre = new Label("Fiche de Suivi");
        titre.setPrefWidth(300);
        titre.setStyle("-fx-text-fill:#48efa6; -fx-font-weight: 800; -fx-font-size:30;");

        Button retourButton = new Button("retour");
        retourButton.setStyle("-fx-background-color:#48efa6; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:15;");
        retourButton.prefWidth(500);
        retourButton.prefHeight(10);
        // Set button actions
        retourButton.setOnAction(event -> {
            HelloApplication m=new HelloApplication();
            try {
                m.changeScene("Home.fxml",900,600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button atteint = new Button("Objectifs non atteints");
        atteint.setStyle("-fx-background-color:red; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:15;");
        atteint.prefWidth(500);
        atteint.prefHeight(10);
        // Set button actions
        atteint.setOnAction(event -> {
            if (atteint.getText().equals("Objectifs non atteints")) {
                atteint.setText("Objectifs atteints");
                atteint.setStyle("-fx-background-color:#48efa6; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:15;");
            } else {
                atteint.setText("Objectifs non atteints");
                atteint.setStyle("-fx-background-color:red; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:15;");

            }
        });

        Button addButton = new Button("Ajouter Objectif");
        addButton.setStyle("-fx-background-color:#48efa6; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:15;");
        addButton.prefWidth(500);
        addButton.prefHeight(10);
        // Set button actions
        addButton.setOnAction(event -> {
            try {
                // Load the FXML file
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("AddObjectif.fxml"));

                // Create a new stage
                Stage popupStage = new Stage();

                // Set the scene with the loaded FXML content
                Scene scene = new Scene(root);
                popupStage.setScene(scene);

                // Set properties of the stage (e.g., title)
                popupStage.setTitle("Form");

                // Add event handler to refresh listQ when the stage is closed
                popupStage.setOnHidden(e -> listO.setItems(FXCollections.observableArrayList(fiche.getObjectifs())));

                // Show the stage
                popupStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        // Add a region to create space between name and buttons
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Create a nested HBox for buttons
        HBox buttonsBox = new HBox(10);
        buttonsBox.getChildren().addAll(atteint,addButton,retourButton);
        buttonsBox.setAlignment(Pos.CENTER_LEFT);

        upHbox.getChildren().addAll(titre,spacer,buttonsBox);
        //************************************************ La list des questions ****************************************** //

        // Disable selection effect in the ListView
        listO.setFocusTraversable(false);
        listO.setSelectionModel(new ModifierFicheController.NoSelectionModel<>());

        ObservableList<Objectif> observableQuestionAnam = FXCollections.observableArrayList(fiche.getObjectifs());
        listO.setItems(observableQuestionAnam);

        listO.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Objectif> call(ListView<Objectif> listView) {
                return new ListCell<Objectif>() {
                    @Override
                    protected void updateItem(Objectif item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            TextField name = new TextField(item.getNom());
                            TextField type= new TextField(item.getType().stringfy());

                            TextField note =new TextField(String.valueOf(item.getNote()));

                            // Set fixed widths for Labels
                            name.setPrefWidth(200);
                            type.setPrefWidth(150);


                            Button supprimerButton = new Button("Supprimer");
                            Button sauvButton = new Button("Sauvegarder");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            sauvButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                fiche.deleteObjectif(getIndex());
                            });

                            sauvButton.setOnAction(event -> {
                                item.setNom(name.getText().toString());
                                if(type.getText().toString().replace(" ","").toUpperCase().equals("MOYENTERME")||type.getText().toString().replace(" ","").toUpperCase().equals("LONGTERME")
                                ||type.getText().toString().replace(" ","").toUpperCase().equals("COURTTERME"))
                                     item.setType(TypeObjectif.valueOf(type.getText().toString().replace(" ","").toUpperCase()));
                                else
                                    System.out.println("Type non valide, non savegarde");
                                item.evaluer( Integer.valueOf(note.getText().toString()));
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(supprimerButton,sauvButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add a region to create space between name and buttons
                            Region spacer = new Region();
                            HBox.setHgrow(spacer, Priority.ALWAYS);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name,type,note,spacer,buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        listO.refresh();
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
