package com.example.tp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Map;

import static com.example.tp.ModifSerieQuestionController.qcm;
public class ModifQCMController {
    @FXML
    private ListView<Map.Entry<String, Integer>> listC;
    @FXML
    private HBox upHbox = new HBox(30);
    ;

    @FXML
    public void initialize() {
        //************************************************* The upper Section ****************************************//
        upHbox.setPrefHeight(100);
        upHbox.setAlignment(Pos.CENTER_LEFT);
        upHbox.setStyle("-fx-padding: 0 20;");

        Label titre = new Label("QCM");
        titre.setPrefWidth(70);
        titre.setStyle("-fx-text-fill:#48efa6; -fx-font-weight: 800; -fx-font-size:18;");

        TextField text = new TextField(qcm.getText());
        text.setPrefWidth(400);
        text.setStyle("-fx-font-weight: 800; -fx-font-size:18;");

        Button saveButton = new Button("sauvegarder");
        saveButton.setStyle("-fx-background-color:#48efa6; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:18;");
        saveButton.prefWidth(400);
        saveButton.prefHeight(10);
        // Set button actions
        saveButton.setOnAction(event -> {
            qcm.setText(text.getText().toString());
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
        buttonsBox.getChildren().addAll(retourButton, saveButton);
        buttonsBox.setAlignment(Pos.CENTER_LEFT);

        // Add a region to create space between name and buttons
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        // Add a fixed-width spacer between the titre and capacite
        Region fixedSpacer = new Region();
        fixedSpacer.setPrefWidth(20);

        upHbox.getChildren().addAll(titre, fixedSpacer,text, spacer, buttonsBox);
        //************************************************* La list des Choix *****************************************//
        // Disable selection effect in the ListView
        listC.setFocusTraversable(false);
        listC.setSelectionModel(new NoSelectionModel<>());

        listC.setItems(FXCollections.observableArrayList(qcm.getChoix().entrySet()));

        listC.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Map.Entry<String, Integer>> call(ListView<Map.Entry<String, Integer>> param) {
                return new ListCell<>() {
                    private final TextField textField = new TextField();
                    private final Button saveButton = new Button("Save");
                    private final Button deleteButton = new Button("Delete");
                    private final Button toggleCorrectButton = new Button();
                    private final HBox hbox = new HBox(textField, saveButton, deleteButton, toggleCorrectButton);

                    {
                        hbox.setSpacing(20);
                        hbox.setPrefHeight(50);
                        hbox.setAlignment(Pos.CENTER_LEFT);
                        // Add hover effect
                        setOnMouseEntered(event -> {
                            if (getItem() != null && !isEmpty()) {
                                setStyle("-fx-background-color: #e6e7e5;");
                            }
                        });
                        setOnMouseExited(event -> {
                            if (getItem() != null && !isEmpty()) {
                                setStyle("-fx-background-color: white;");
                            }
                        });

                        deleteButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                        toggleCorrectButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                        saveButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                        textField.setPrefWidth(400); // Set preferred width for the text field

                        saveButton.setOnAction(event -> {
                            Map.Entry<String, Integer> item = getItem();
                            if (item != null) {
                                qcm.getChoix().put(textField.getText(), item.getValue());
                                listC.getItems().set(getIndex(), new java.util.AbstractMap.SimpleEntry<>(textField.getText(), item.getValue()));
                            }
                        });

                        deleteButton.setOnAction(event -> {
                            Map.Entry<String, Integer> item = getItem();
                            if (item != null) {
                                qcm.getChoix().remove(item.getKey());
                                listC.getItems().remove(item);
                                listC.refresh();
                            }
                        });

                        toggleCorrectButton.setOnAction(event -> {
                            Map.Entry<String, Integer> item = getItem();
                            if (item != null) {
                                int newValue = item.getValue() == 1 ? 0 : 1;
                                qcm.getChoix().put(item.getKey(), newValue);
                                listC.getItems().set(getIndex(), new java.util.AbstractMap.SimpleEntry<>(item.getKey(), newValue));
                            }
                        });

                    }

                    @Override
                    protected void updateItem(Map.Entry<String, Integer> item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty || item == null) {
                            setText(null);
                            setGraphic(null);
                            setBackground(null);
                            setStyle(null);
                            setOnMouseEntered(null);
                            setOnMouseExited(null);
                        } else {
                            textField.setText(item.getKey());
                            toggleCorrectButton.setText(item.getValue() == 1 ? "Set Incorrect" : "Set Correct");
                            if (item.getValue() == 1) {
                                setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
                                setOnMouseEntered(event -> setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null))));
                                setOnMouseExited(event -> setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null))));
                            } else {
                                setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                                setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                                setOnMouseExited(event -> setStyle("-fx-background-color: white;"));
                            }
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });
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

    public  void addChoix(){
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("addChoix.fxml"));

            // Create a new stage
            Stage popupStage = new Stage();

            // Set the scene with the loaded FXML content
            Scene scene = new Scene(root);
            popupStage.setScene(scene);

            // Set properties of the stage (e.g., title)
            popupStage.setTitle("Form");
            popupStage.setOnHidden(e -> listC.setItems(FXCollections.observableArrayList(qcm.getChoix().entrySet())));

            // Show the stage
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
