package com.example.tp;

import com.example.tp.Models.SerieExo;
import com.example.tp.Models.SerieQuestion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

import static com.example.tp.ModifierBOController.ep;


public class ModifierEpreuveController {

    HelloApplication m = new HelloApplication();
    public static SerieExo sExo;
    public static SerieQuestion sQuest;

    public static boolean isSQuest;

    @FXML
    private ListView<SerieQuestion> serieQ;
    @FXML
    private ListView<SerieExo> serieE;
    @FXML
    private TextArea obs;
    @FXML
    public void initialize() {

         obs.setText(ep.getObservations());
        //Serie Questions list
        serieQ.setFocusTraversable(false);
        serieQ.setSelectionModel(new ModifierEpreuveController.NoSelectionModel<>());

        ObservableList<SerieQuestion> observableQuestions = FXCollections.observableArrayList(ep.getSerieQuestions());
        serieQ.setItems(observableQuestions);
        serieQ.setCellFactory(new Callback<>() {
            @Override
            public ListCell<SerieQuestion> call(ListView<SerieQuestion> listView) {
                return new ListCell<SerieQuestion>() {
                    @Override
                    protected void updateItem(SerieQuestion item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);
                            // Create Labels instead of Text nodes
                            Label nom = new Label(item.getNom());
                            Label capacite = new Label(item.getCapacite());
                            TextField conclusion=new TextField(item.getConclusion());
                            Float scoreTotale = item.calculerScoreTotale();
                            Label ScoreTotale;

                            if (scoreTotale == null || scoreTotale.isNaN()) {
                                ScoreTotale = new Label("0.0");
                            } else {
                                ScoreTotale = new Label(String.valueOf(scoreTotale));
                            }

                            // Set fixed widths for Labels
                            nom.setPrefWidth(70);
                            nom.setMaxWidth(70);

                            capacite.setPrefWidth(100);
                            capacite.setMaxWidth(100);

                            ScoreTotale.setPrefWidth(70);
                            ScoreTotale.setMaxWidth(70);

                            Button supprimerButton = new Button("Supprimer");
                            Button modifierButton = new Button("Modifier");
                            Button saveButton = new Button("sauvgarder");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            modifierButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            saveButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                ep.deleteSerieQuestionsIndx(getIndex());
                            });
                            saveButton.setOnAction(event -> {
                                item.setConclusion(conclusion.getText().toString());
                            });

                            modifierButton.setOnAction(event -> {
                                sQuest=item;
                                try {
                                    m.changeScene("SerieQuestionEpreuve.fxml",900,600);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(saveButton,supprimerButton, modifierButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add elements to outer HBox
                            HBox.setHgrow(conclusion, Priority.ALWAYS);  // Allow conclusion TextField to take remaining space
                            conclusion.setMaxWidth(Double.MAX_VALUE);  // Allow it to grow to maximum width

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(nom, capacite,ScoreTotale, conclusion, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        serieQ.refresh();
        //Serie Exercices list

        serieE.setFocusTraversable(false);
        serieE.setSelectionModel(new ModifierEpreuveController.NoSelectionModel<>());

        ObservableList<SerieExo> observableExos = FXCollections.observableArrayList(ep.getSerieExercices());
        serieE.setItems(observableExos);
        serieE.setCellFactory(new Callback<>() {
            @Override
            public ListCell<SerieExo> call(ListView<SerieExo> listView) {
                return new ListCell<SerieExo>() {
                    @Override
                    protected void updateItem(SerieExo item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);
                            // Create Labels instead of Text nodes
                            Label nom = new Label(item.getNom());
                            Label capacite = new Label(item.getCapacite());
                            TextField conclusion=new TextField(item.getConclusion());
                            Label ScoreTotale= new Label(String.valueOf(item.calculerScoreTotale()));
                            // Set fixed widths for Labels
                            nom.setPrefWidth(70);
                            nom.setMaxWidth(70);

                            capacite.setPrefWidth(100);
                            capacite.setMaxWidth(100);

                            ScoreTotale.setPrefWidth(70);
                            ScoreTotale.setMaxWidth(70);

                            Button supprimerButton = new Button("Supprimer");
                            Button modifierButton = new Button("Modifier");
                            Button saveButton = new Button("sauvgarder");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            modifierButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            saveButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                ep.deleteSerieQuestionsIndx(getIndex());
                            });
                            saveButton.setOnAction(event -> {
                                item.setConclusion(conclusion.getText().toString());
                            });

                            modifierButton.setOnAction(event -> {
                               sExo=item;
                                try {
                                    m.changeScene("SerieExoEpreuve.fxml",900,600);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(saveButton,supprimerButton, modifierButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add elements to outer HBox
                            HBox.setHgrow(conclusion, Priority.ALWAYS);  // Allow conclusion TextField to take remaining space
                            conclusion.setMaxWidth(Double.MAX_VALUE);  // Allow it to grow to maximum width

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(nom, capacite,ScoreTotale, conclusion, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        serieE.refresh();

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

    public  void saveObs(){
        ep.setObservations(obs.getText().toString());
    }

    public void retour() throws IOException {
        m.changeScene("Home.fxml",900,600);
    }

    @FXML
    public void AddSerie(ActionEvent event) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("AddSerieEpreuve.fxml"));

            // Create a new stage
            Stage popupStage = new Stage();

            // Set the scene with the loaded FXML content
            Scene scene = new Scene(root);
            popupStage.setScene(scene);

            // Set properties of the stage (e.g., title)
            popupStage.setTitle("Form");

            // Check which button triggered the event
            if (((Button) event.getSource()).getId().equals("addSE")) {
                // Action for btnSerieExo
                popupStage.setOnHidden(e -> serieE.setItems(FXCollections.observableArrayList(ep.getSerieExercices())));
                isSQuest=false;
            } else if (((Button) event.getSource()).getId().equals("addSQ")) {
                // Action for btnSerieQ
                popupStage.setOnHidden(e -> serieQ.setItems(FXCollections.observableArrayList(ep.getSerieQuestions())));
                isSQuest=true;
            }

            // Show the stage
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
