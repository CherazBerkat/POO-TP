package com.example.tp;

import java.util.Map;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.io.IOException;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import com.example.tp.Models.*;

import static com.example.tp.HelloApplication.orthophonist;

public class HomeController {
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
    private TextField textfieldDateC;
    @FXML
    private TextField textfieldDateAG;
    @FXML
    private TextField textfieldDateSS;

    @FXML
    private BarChart barChart;
    @FXML
    private PieChart pieChart;
    @FXML
    private ListView<Anamnese> anamList;
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
         XYChart.Series serie1=new XYChart.Series<>();
         serie1.setName("troubles");
        Map<Trouble, Integer> troubleMap = orthophonist.countTroubles();
        for (Map.Entry<Trouble, Integer> entry : troubleMap.entrySet()) {
            Trouble trouble = entry.getKey();
            if (trouble != null) {
                // Only proceed if the trouble object is not null
                serie1.getData().add(new XYChart.Data(trouble.getNom(),entry.getValue()));
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
                pieChartData.add(new PieChart.Data(trouble2.getNom(), entry2.getValue()*100));
            }
        }

        pieChartData.forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(),": ",data.pieValueProperty(),"%")));
        pieChart.getData().addAll(pieChartData);

        //Anamneses list

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
                                Text name = new Text("Anamnese" + (getIndex() + 1));


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
                                   System.out.println("in modifier");//////////////////////////////////////////////
                                });

                                // Create a nested HBox for buttons
                                HBox buttonsBox = new HBox(10);
                                buttonsBox.getChildren().addAll(supprimerButton, modifierButton);

                                // Add a region to create space between name and buttons
                                Region spacer = new Region();
                                HBox.setHgrow(spacer, Priority.ALWAYS);

                                // Add elements to outer HBox
                                hBox.getChildren().addAll(name, spacer, buttonsBox);
                                setGraphic(hBox);
                            } else {
                                setGraphic(null);
                            }
                        }

                    };

                }
            });
        anamList.refresh();
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

    public  void signOut ()throws IOException{
        HelloApplication m = new HelloApplication();
        m.changeScene("logIN.fxml",400,500);
        orthophonist.save();
        System.out.println("Signed Out");
        System.out.println("data saved");
    }
}
