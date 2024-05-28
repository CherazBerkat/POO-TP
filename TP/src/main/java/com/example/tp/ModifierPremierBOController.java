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

import static com.example.tp.DossierController.premierBO;
import static com.example.tp.HelloApplication.orthophonist;
import static com.example.tp.HomeController.doss;

public class ModifierPremierBOController {
    @FXML
    private ListView<QuestionAnam> listviewAnam;
    @FXML
    private Button buttonRetour;
    private ObservableList<QuestionAnam> observableAnam;

    private static EpreuveClinique ep;

    private HelloApplication m= new HelloApplication();
    @FXML
    private Button buttonAjouterAnam;

    public void initialize() {

        // Set button actions
        buttonRetour.setOnAction(event -> {
            HelloApplication m = new HelloApplication();
            try {
                m.changeScene("Dossier.fxml", 900, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //************************list Epreuves********************************
        // Disable selection effect in the ListView
        if(premierBO.getAnamnese()!=null) {
            listviewAnam.setFocusTraversable(false);
            listviewAnam.setSelectionModel(new ModifierPremierBOController.NoSelectionModel<>());

            // Populate the ListView with Epreuve objects
            observableAnam = FXCollections.observableArrayList(premierBO.getAnamnese().getQuestions());
            listviewAnam.setItems(observableAnam);
        }
            listviewAnam.setCellFactory(new Callback<>() {
                @Override
                public ListCell<QuestionAnam> call(ListView<QuestionAnam> listView) {
                    return new ListCell<QuestionAnam>() {
                        @Override
                        protected void updateItem(QuestionAnam item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item != null && !empty) {
                                HBox hBox = new HBox(20);
                                hBox.setPrefHeight(50);
                                hBox.setAlignment(Pos.CENTER_LEFT);

                                Label name = new Label("Question Anamnese" + (getIndex() + 1));
                                Label type;
                                if (item instanceof QuestionAnamAdult) {
                                    type = new Label("Anamnese Adulte");
                                } else {
                                    type = new Label("Anamnese Enfant");
                                }
                                Label categorie;
                                if (item instanceof QuestionAnamAdult) {
                                    categorie = new Label(((QuestionAnamAdult) item).getTypeAdult().toString());
                                } else {
                                    categorie = new Label(((QuestionAnamEnfant) item).getTypeEnfant().toString());
                                }
                                Label text = new Label(item.getText());
                                //Set fixed widths for Labels
                                name.setPrefWidth(100);
                                type.setPrefWidth(100);
                                categorie.setPrefWidth(200);
                                // Ensure the type takes up remaining space
                                HBox.setHgrow(text, Priority.ALWAYS);
                                text.setMaxWidth(Double.MAX_VALUE);


                                // Add hover effect
                                setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                                setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                                // Add elements to outer HBox
                                hBox.getChildren().addAll(name, type, categorie, text);
                                setGraphic(hBox);
                            } else {
                                setGraphic(null);
                            }
                        }
                    };
                }
            });
            listviewAnam.refresh();
        listviewAnam.refresh();
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

    public void AddAnam(ActionEvent event) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("addAnam.fxml"));

            // Create a new stage
            Stage popupStage = new Stage();

            // Set the scene with the loaded FXML content
            Scene scene = new Scene(root);
            popupStage.setScene(scene);

            // Set properties of the stage (e.g., title)
            popupStage.setTitle("Form");

            // Refresh the ListView when the popup is closed
            popupStage.setOnHidden(e -> { listviewAnam.setItems(FXCollections.observableArrayList(premierBO.getAnamnese().getQuestions()));
                listviewAnam.refresh();
                // Re-enable the button and restore its original color
                buttonAjouterAnam.setDisable(true);
                buttonAjouterAnam.setStyle("-fx-background-color:gray; -fx-text-fill: #000000; -fx-font-weight: 700;");
            });

            // Show the stage
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
