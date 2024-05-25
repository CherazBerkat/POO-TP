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

import static com.example.tp.HelloApplication.orthophonist;

public class HomeController {
    public static Anamnese anam;
    public static SerieExo sExo;
    public static SerieQuestion sQuest;

    public static Dossier doss;

    public static boolean isSQuest;
    @FXML
    private TextField username;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adr;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private PasswordField passwd;
    @FXML
    private Label label;
    @FXML
    private Label label1;
    private Timeline timeline;
    @FXML
    private DatePicker datepickerDateC;
    @FXML
    private DatePicker datepickerDateAG;
    @FXML
    private DatePicker datepickerDateSS;
    @FXML
    private TextField textfieldHeureC;
    @FXML
    private TextField textfieldHeureAG;
    @FXML
    private TextField textfieldHeureSS;
    @FXML
    private TextField textfieldNom;
    @FXML
    private TextField textfieldPrenom;
    @FXML
    private TextField textfieldAge;
    @FXML
    private TextField textfieldDuree;
    @FXML
    private ComboBox comboboxAge;
    @FXML
    private ComboBox comboboxDeroulement;
    @FXML
    private TextField textfieldThematique;
    @FXML
    private TextField textfieldNumDossier;
    @FXML
    private ListView listviewPatients;
    @FXML
    private TextField textfieldNum;
    @FXML
    private ListView<Dossier> listviewDossiers;
    @FXML
    private BarChart barChart;
    @FXML
    private PieChart pieChart;
    @FXML
    private ListView<Anamnese> anamList;
    @FXML
    private ListView<SerieQuestion> serieQ;
    @FXML
    private ListView<SerieExo> serieE;
    HelloApplication m = new HelloApplication();
    @FXML
    public void initialize() {
        // Create a timeline
        timeline = new Timeline();
        username.setText(orthophonist.getUserName());
        nom.setText(orthophonist.getNom());
        prenom.setText(orthophonist.getPrenom());
        adr.setText(orthophonist.getAdr());
        email.setText(orthophonist.getMail());
        tel.setText(orthophonist.getTel());
        passwd.setText(orthophonist.getPasswd());
        label1.setText(orthophonist.getUserName());
        // Add a keyframe to clear the label text after a short delay
        KeyFrame clearFrame = new KeyFrame(Duration.seconds(1), e -> label.setText(""));
        timeline.getKeyFrames().add(clearFrame);
        //creating the barChart
        XYChart.Series serie1 = new XYChart.Series<>();
        serie1.setName("troubles");
        Map<Trouble, Integer> troubleMap = orthophonist.countTroubles();
        for (Map.Entry<Trouble, Integer> entry : troubleMap.entrySet()) {
            Trouble trouble = entry.getKey();
            if (trouble != null) {
                // Only proceed if the trouble object is not null
                serie1.getData().add(new XYChart.Data(trouble.getNom(), entry.getValue()));
            } else {
                System.out.println("Encountered a null Trouble object in the map.");
            }
        }
        barChart.getData().add(serie1);
        //creating the pieChart
        Map<Trouble, Float> troublePerMap = orthophonist.countTroublesPercentages(troubleMap);
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Map.Entry<Trouble, Float> entry2 : troublePerMap.entrySet()) {
            Trouble trouble2 = entry2.getKey();
            if (trouble2 != null) {
                pieChartData.add(new PieChart.Data(trouble2.getNom(), entry2.getValue() * 100));
            }
        }

        pieChartData.forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(), ": ", data.pieValueProperty(), "%")));
        pieChart.getData().addAll(pieChartData);
        //Serie Questions list

        serieQ.setFocusTraversable(false);
        serieQ.setSelectionModel(new HomeController.NoSelectionModel<>());

        ObservableList<SerieQuestion> observableQuestions = FXCollections.observableArrayList(orthophonist.getSerieQuestions());
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
                            Label name = new Label("SerieQuestion" + (getIndex() + 1));
                            Label nom = new Label(item.getNom());
                            Label capacite = new Label(item.getCapacite());

                            // Set fixed widths for Labels
                            name.setPrefWidth(100);
                            name.setMaxWidth(100);

                            nom.setPrefWidth(100);
                            nom.setMaxWidth(100);

                            capacite.setPrefWidth(100);
                            capacite.setMaxWidth(100);

                            Button supprimerButton = new Button("Supprimer");
                            Button modifierButton = new Button("Modifier");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            modifierButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                orthophonist.deleteSerieQuestionsIndx(getIndex());
                            });

                            modifierButton.setOnAction(event -> {
                                sQuest=item;
                                try {
                                    m.changeScene("modifSerieQuestion.fxml",900,600);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(20);
                            buttonsBox.getChildren().addAll(supprimerButton, modifierButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add a region to create space between name and buttons
                            Region spacer = new Region();
                            HBox.setHgrow(spacer, Priority.ALWAYS);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, nom, capacite, spacer, buttonsBox);
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
        serieE.setSelectionModel(new HomeController.NoSelectionModel<>());

        ObservableList<SerieExo> observableExos = FXCollections.observableArrayList(orthophonist.getSerieExos());
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
                            Label name = new Label("SerieExo" + (getIndex() + 1));
                            Label nom = new Label(item.getNom());
                            Label capacite = new Label(item.getCapacite());

                            // Set fixed widths for Labels
                            name.setPrefWidth(100);
                            name.setMaxWidth(100);

                            nom.setPrefWidth(100);
                            nom.setMaxWidth(100);

                            capacite.setPrefWidth(100);
                            capacite.setMaxWidth(100);

                            Button supprimerButton = new Button("Supprimer");
                            Button modifierButton = new Button("Modifier");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            modifierButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                orthophonist.deleteSerieExosIndx(getIndex());
                            });

                            modifierButton.setOnAction(event -> {
                               sExo=item;
                                try {
                                    m.changeScene("modifSerieExo.fxml",900,600);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(10);
                            buttonsBox.getChildren().addAll(supprimerButton, modifierButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add a region to create space between name and buttons
                            Region spacer = new Region();
                            HBox.setHgrow(spacer, Priority.ALWAYS);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, nom, capacite, spacer, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        serieE.refresh();

        //Anamneses list

        // Disable selection effect in the ListView
        anamList.setFocusTraversable(false);
        anamList.setSelectionModel(new HomeController.NoSelectionModel<>());

        ObservableList<Anamnese> observableAnamneses = FXCollections.observableArrayList(orthophonist.getAnamneses());
        anamList.setItems(observableAnamneses);
        anamList.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Anamnese> call(ListView<Anamnese> listView) {
                return new ListCell<Anamnese>() {
                    @Override
                    protected void updateItem(Anamnese item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            // Create Labels instead of Text nodes
                            Label name = new Label("Anamnese" + (getIndex() + 1));
                            Label type = new Label(item.getClass().getSimpleName());

                            // Set fixed widths for Labels
                            name.setPrefWidth(100);
                            type.setPrefWidth(100);

                            Button supprimerButton = new Button("Supprimer");
                            Button modifierButton = new Button("Modifier");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            modifierButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                orthophonist.deleteAnamneseIndx(getIndex());
                            });

                            modifierButton.setOnAction(event -> {
                                anam=item;
                                try {
                                    m.changeScene("modifAnam.fxml",900,600);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(10);
                            buttonsBox.getChildren().addAll(supprimerButton, modifierButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add a region to create space between name and buttons
                            Region spacer = new Region();
                            HBox.setHgrow(spacer, Priority.ALWAYS);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, type, spacer, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        anamList.refresh();

        //Dossier list

// Disable selection effect in the ListView
        listviewDossiers.setFocusTraversable(false);
        listviewDossiers.setSelectionModel(new HomeController.NoSelectionModel<>());

        ObservableList<Dossier> observableDossier = FXCollections.observableArrayList(orthophonist.getDossiers());
        listviewDossiers.setItems(observableDossier);
        listviewDossiers.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Dossier> call(ListView<Dossier> listView) {
                return new ListCell<Dossier>() {
                    @Override
                    protected void updateItem(Dossier item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox hBox = new HBox(20);
                            hBox.setPrefHeight(50);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            // Create Labels instead of Text nodes
                            Label name = new Label("Dossier" + (getIndex() + 1));
                            Label type = new Label(item.getClass().getSimpleName());

                            // Set fixed widths for Labels
                            name.setPrefWidth(100);
                            type.setPrefWidth(100);

                            Button supprimerButton = new Button("Supprimer");
                            Button modifierButton = new Button("Modifier");

                            // Styling buttons
                            supprimerButton.setStyle("-fx-background-color:white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");
                            modifierButton.setStyle("-fx-background-color: white; -fx-text-fill: #48efa6; -fx-font-weight: 700;");

                            // Set button actions
                            supprimerButton.setOnAction(event -> {
                                getListView().getItems().remove(item);
                                orthophonist.deleteDossierIndx(getIndex());
                            });

                            modifierButton.setOnAction(event -> {
                                doss= item;
                                try {
                                    m.changeScene("Dossier.fxml", 900, 600);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });


                            // Add hover effect
                            setOnMouseEntered(event -> setStyle("-fx-background-color: #e6e7e5;"));
                            setOnMouseExited(event -> setStyle("-fx-background-color: white;"));

                            // Create a nested HBox for buttons
                            HBox buttonsBox = new HBox(10);
                            buttonsBox.getChildren().addAll(supprimerButton, modifierButton);
                            buttonsBox.setAlignment(Pos.CENTER_LEFT);

                            // Add a region to create space between name and buttons
                            Region spacer = new Region();
                            HBox.setHgrow(spacer, Priority.ALWAYS);

                            // Add elements to outer HBox
                            hBox.getChildren().addAll(name, type, spacer, buttonsBox);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        listviewDossiers.refresh();


        //add options to ComboBoxes

        comboboxAge.getItems().addAll("Adulte", "Enfant");

        comboboxDeroulement.getItems().addAll("ENLIGNE", "ENPRESENTIEL");
    }

    public void updateInfos(ActionEvent event)throws IOException {
      majInfos();
    }

    public void majInfos(){
        label.setText("Data updated!");
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), e -> {
            label.setText("");
            // Stop the timeline
            timeline.stop();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        orthophonist.setMail(email.getText().toString());
        orthophonist.setNom(nom.getText().toString());
        orthophonist.setPasswd(passwd.getText().toString());
        orthophonist.setPrenom(prenom.getText().toString());
        orthophonist.setTel(tel.getText().toString());
        orthophonist.setUserName(username.getText().toString());
        orthophonist.setAdr(adr.getText().toString());
        label1.setText(orthophonist.getUserName());
        orthophonist.affichInfo();
    }
    private LocalTime parseTime(String timeText) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(timeText, formatter);
        } catch (DateTimeParseException e) {
            // Afficher une alerte en cas de format incorrect
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Time Format");
            alert.setContentText("Please enter the time in the format HH:mm");
            alert.showAndWait();
            return null;
        }
    }
    private boolean checkIfAdult(String selectedOption) {
        return "Adulte".equals(selectedOption);
    }
    public void ajouterConsultation()
    {
        Consultation consultation;
        String timeText = textfieldHeureC.getText();
        LocalTime heure = parseTime(timeText);
        String option = comboboxAge.getValue().toString();
        Boolean adult = checkIfAdult(option);
        consultation= new Consultation(datepickerDateC.getValue(),heure,textfieldNom.getText().toString(),textfieldPrenom.getText().toString(),Integer.parseInt(textfieldAge.getText()),adult);
        orthophonist.addRendezVous(consultation);
    }

    public void ajouterSeanceSuivi()
    {
        SeanceSuivi seance;
        String timeText = textfieldHeureSS.getText();
        LocalTime heure = parseTime(timeText);
        seance= new SeanceSuivi(datepickerDateSS.getValue(),heure,Integer.parseInt(textfieldNumDossier.getText().toString()));
        seance.setDeroulement(Deroulement.valueOf(comboboxDeroulement.getValue().toString()));
        orthophonist.addRendezVous(seance);
        orthophonist.recherchePatient(Integer.parseInt(textfieldNumDossier.getText().toString())).ajouterRendezVous(seance);
    }

    public void ajouterAtelierGroupe()
    {
        Atelier atelier;
        String timeText = textfieldHeureAG.getText();
        LocalTime heure = parseTime(timeText);
        atelier = new Atelier(datepickerDateAG.getValue(),heure,textfieldThematique.getText().toString());
        for(int i=0;i<listviewPatients.getItems().size();i++)
        {
            atelier.ajouterPatient(Integer.parseInt(listviewPatients.getItems().get(i).toString()));
            orthophonist.recherchePatient(Integer.parseInt(listviewPatients.getItems().get(i).toString())).ajouterRendezVous(atelier);
        }
        orthophonist.addRendezVous(atelier);
    }

    public void ajouterNum()
    {
        listviewPatients.getItems().add(textfieldNum.getText().toString());
    }

    public void pageAjoutPatient() throws IOException {
        m.changeScene("ajouterDossier.fxml",500,400);
    }

    public  void signOut ()throws IOException{
        HelloApplication m = new HelloApplication();
        m.changeScene("logIN.fxml",400,500);
        orthophonist.save();
        System.out.println("Signed Out");
        System.out.println("data saved");
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
    public void addAnamAdult(){
        orthophonist.addAnamnese(new AnamneseAdulte());
        ObservableList<Anamnese> observableAnamneses = FXCollections.observableArrayList(orthophonist.getAnamneses());
        anamList.setItems(observableAnamneses);
    }
    public void addAnamEnfant(){
        orthophonist.addAnamnese(new AnamneseEnfant());
        ObservableList<Anamnese> observableAnamneses = FXCollections.observableArrayList(orthophonist.getAnamneses());
        anamList.setItems(observableAnamneses);
    }


    @FXML
    public void AddSerie(ActionEvent event) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("AddSerie.fxml"));

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
                popupStage.setOnHidden(e -> serieE.setItems(FXCollections.observableArrayList(orthophonist.getSerieExos())));
                isSQuest=false;
            } else if (((Button) event.getSource()).getId().equals("addSQ")) {
                // Action for btnSerieQ
                popupStage.setOnHidden(e -> serieQ.setItems(FXCollections.observableArrayList(orthophonist.getSerieQuestions())));
                isSQuest=true;
            }

            // Show the stage
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
