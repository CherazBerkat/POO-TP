package com.example.tp;


import com.example.tp.Models.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.Callback;

import java.io.IOException;

import static com.example.tp.ModifierEpreuveController.sQuest;

public class SerieQuestionEpreuveController {
    HelloApplication m = new HelloApplication();
    @FXML
    private ListView<Question> listQ;
    @FXML
    private HBox upHbox = new HBox(30);
    ;

    @FXML
    public void initialize() {
        //************************************************* The upper Section ****************************************//
        upHbox.setPrefHeight(100);
        upHbox.setAlignment(Pos.CENTER_LEFT);
        upHbox.setStyle("-fx-padding: 0 20;");

        Label titre = new Label(sQuest.getNom());
        titre.setPrefWidth(200);
        titre.setStyle("-fx-text-fill:#48efa6; -fx-font-weight: 800; -fx-font-size:18;");

        Label capacite = new Label(sQuest.getCapacite());
        capacite.setPrefWidth(400);
        capacite.setStyle("-fx-font-weight: 800; -fx-font-size:18;");

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

        // Add a region to create space between name and buttons
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        // Add a fixed-width spacer between the titre and capacite
        Region fixedSpacer = new Region();
        fixedSpacer.setPrefWidth(20);

        upHbox.getChildren().addAll(titre, fixedSpacer, capacite, spacer, retourButton);
        //************************************************* La list des Questions *****************************************//
        // Disable selection effect in the ListView
        listQ.setFocusTraversable(false);
        listQ.setSelectionModel(new SerieQuestionEpreuveController.NoSelectionModel<>());

        ObservableList<Question> observableQuestions = FXCollections.observableArrayList(sQuest.getQuestions());
        listQ.setItems(observableQuestions);
        listQ.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Question> call(ListView<Question> listView) {
                return new ListCell<Question>() {
                    @Override
                    protected void updateItem(Question item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            Label type = new Label(item.getClass().getSimpleName());
                            Label text= new Label(item.getText());
                            TextField score=new TextField(String.valueOf(item.getScore()));

                            // Set fixed widths for Labels
                            type.setPrefWidth(70);
                            score.setPrefWidth(70);

                            // Ensure the TextField takes up remaining space
                            HBox.setHgrow(text, Priority.ALWAYS);
                            text.setMaxWidth(Double.MAX_VALUE);

                            Button sauvButton = new Button("Sauvegarder");
                            // Styling buttons
                            sauvButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            // Set button actions

                            sauvButton.setOnAction(event -> {
                                item.setScore(Integer.valueOf(score.getText().toString()));
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));


                            // Add elements to outer HBox
                            hBox.getChildren().addAll(type,text,score, sauvButton);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        listQ.refresh();
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
