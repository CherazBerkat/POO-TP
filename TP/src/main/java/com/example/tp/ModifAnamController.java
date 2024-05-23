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

public class ModifAnamController {
    private AnamneseAdulte anam =new AnamneseAdulte();
    @FXML
    private ListView<QuestionAnam> listQ;
    @FXML
    private HBox upHbox=new HBox(20);;
    @FXML
    public void initialize() {
        /////////////////////////////////////////////////////////////////////////////////////////////
        String txt;
        for (int i=0;i<=10;i++){
            txt="text"+i;
            anam.ajouterQuestion(new QuestionAnamAdult(txt,TypeAnamneseAdulte.HISTOIREDEMALADIE));
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////
//************************************************* The upper Section ***********************************************//
        upHbox.setPrefHeight(100);
        upHbox.setAlignment(Pos.CENTER_LEFT);
        upHbox.setStyle("-fx-padding: 0 20;");

        Label titre = new Label(anam.getClass().getSimpleName());
        titre.setPrefWidth(500);
        titre.setStyle("-fx-text-fill:#48efa6; -fx-font-weight: 800; -fx-font-size:30;");

        Button retourButton = new Button("retour");
        retourButton.setStyle("-fx-background-color:#48efa6; -fx-text-fill:white ; -fx-font-weight: 700;-fx-font-size:18;");
        retourButton.prefWidth(450);
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

        // Add a region to create space between name and buttons
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        upHbox.getChildren().addAll(titre,spacer,retourButton);
 //************************************************* La list des questions ***********************************************//

        // Disable selection effect in the ListView
        listQ.setFocusTraversable(false);
        listQ.setSelectionModel(new NoSelectionModel<>());

        ObservableList<QuestionAnam> observableQuestionAnam = FXCollections.observableArrayList(anam.getQuestions());
        listQ.setItems(observableQuestionAnam);

        listQ.setCellFactory(new Callback<>() {
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

                            Label name = new Label("Question" + (getIndex() + 1));
                            Label type;
                            if (item instanceof QuestionAnamEnfant)
                                type = new Label(item.getTypeAdult().stringfy(item.getTypeAdult()));
                            else
                                type = new Label(item.getTypeEnfant().stringfy(item.getTypeEnfant()));

                            TextField text =new TextField(item.getText());

                            // Set fixed widths for Labels
                            name.setPrefWidth(70);
                            type.setPrefWidth(150);

                            // Ensure the TextField takes up remaining space
                            HBox.setHgrow(text, Priority.ALWAYS);
                            text.setMaxWidth(Double.MAX_VALUE);

                            Button supprimerButton = new Button("Supprimer");
                            Button sauvButton = new Button("Sauvegarder");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            sauvButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                anam.deleteQuestion(getIndex());
                            });

                            sauvButton.setOnAction(event -> {
                                item.setText(text.getText().toString());
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(supprimerButton,sauvButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, type,text, buttonsBox);
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
