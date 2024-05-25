package com.example.tp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.example.tp.Models.*;

public class HelloApplication extends Application {
    private static Stage stg;
    public static Ortho orthophonist;
    public static final String DIRECTORY_PATH = "src/main/resources/com/example/tp/datafile";
    public static final String FILE_NAME = "tp.dat";
    public static final Path FILE_PATH = Paths.get(DIRECTORY_PATH, FILE_NAME);
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("logIN.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400,500);
        if (Files.exists(FILE_PATH)) {
            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(FILE_PATH))) {
                orthophonist = (Ortho) in.readObject();
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("ortho not yet exists");
                orthophonist = new Ortho();
            }
        } else {
            orthophonist = new Ortho();
            createFile();
        }
        /************************************************test Data***********************************************/
       /* TypeTrouble troubleType1 = TypeTrouble.DEGLUTITION;
        TypeTrouble troubleType2 = TypeTrouble.NEURODEVELOPPEMENTAUX;
        TypeTrouble troubleType3 = TypeTrouble.COGNITIFS;

         Dossier d1=new Dossier();

         Diagnostic dg11=new Diagnostic();
        Trouble T1=new Trouble("Trouble1",troubleType1);
        Trouble T2=new Trouble("Trouble2",troubleType2);
        Trouble T3=new Trouble("Trouble3",troubleType3);
        Trouble T4=new Trouble("Trouble4",troubleType3);
        dg11.ajouterTrouble(T1);
        dg11.ajouterTrouble(T2);
        dg11.ajouterTrouble(T3);

        Diagnostic dg12=new Diagnostic();
        Trouble T13=new Trouble("Touble13",troubleType3);
        dg12.ajouterTrouble(T1);
        dg12.ajouterTrouble(T2);
        dg12.ajouterTrouble(T13);

         BO b11=new BO();
         b11.setDiagnostic(dg11);

         BO b12=new BO();
         b12.setDiagnostic(dg12);

         d1.ajouterBO(b11);
         d1.ajouterBO(b12);
         orthophonist.addDossier(d1);

        Dossier d2=new Dossier();

        Diagnostic dg21=new Diagnostic();
        dg21.ajouterTrouble(T1);
        dg21.ajouterTrouble(T2);
        dg21.ajouterTrouble(T3);

        Diagnostic dg22=new Diagnostic();
        dg22.ajouterTrouble(T1);
        dg22.ajouterTrouble(T2);
        dg22.ajouterTrouble(T13);
        dg22.ajouterTrouble(T4);
        BO b21=new BO();
        b21.setDiagnostic(dg21);

        BO b22=new BO();
        b22.setDiagnostic(dg22);

        d2.ajouterBO(b21);
        d2.ajouterBO(b22);
        orthophonist.addDossier(d2);
         String nom, capacite;
       for (int i=0;i<=10;i++) {
           nom = "nom" + i;
           capacite = "capacite" + i;
           orthophonist.addSerieQuestions(new SerieQuestion(nom, capacite));
           orthophonist.addSerieExos(new SerieExo(nom, capacite));
           orthophonist.addAnamnese(new AnamneseAdulte());
           orthophonist.addAnamnese(new AnamneseEnfant());
       }
       Anamnese anam=orthophonist.getAnamneses().get(0);
        String txt;
        for (int i=0;i<=10;i++){
            txt="text"+i;
            anam.ajouterQuestion(new QuestionAnamAdult(txt,TypeAnamneseAdulte.HISTOIREDEMALADIE));
        }
        SerieExo s=orthophonist.getSerieExos().get(0);
        for (int i=0;i<=5;i++){
            s.addExo(new Exo("consigne0","materiel0"));
        }
        Anamnese anam2=orthophonist.getAnamneses().get(1);
        for (int i=0;i<=10;i++){
            txt="text"+i;
            anam2.ajouterQuestion(new QuestionAnamEnfant(txt,TypeAnamneseEnfant.DEVELOPPEMENTLANGAGIER));
        }
        SerieQuestion sq=orthophonist.getSerieQuestions().get(0);
        QCM qcm=new QCM("text");
        qcm.addChoix("choix1",false);
        qcm.addChoix("choix2",false);
        qcm.addChoix("choix3",true);
        qcm.addChoix("choix4",false);
        sq.addQuestion(new QRL("text"));
        sq.addQuestion(qcm);
        QCU qcu =new QCU("text");
        qcu.addPropo("choix1",false);
        qcu.addPropo("choix2",false);
        qcu.addPropo("choix3",true);
        qcu.addPropo("choix4",false);
        sq.addQuestion(qcu);*/

        /*******************************************************************************************************/
        stage.setTitle("CabinetPro ManageX");
        stage.setScene(scene);
        stage.show();
    }
   public void stop() {
        orthophonist.save();
    }
    private void createFile() {
        try {
            if (!Files.exists(FILE_PATH.getParent())) {
                Files.createDirectories(FILE_PATH.getParent());
            }
            Files.createFile(FILE_PATH);
            System.out.println(" File created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml, long x, long y) throws IOException {
        // Load the FXML content
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));

        // Create a new Scene with the specified width and height
        Scene scene = new Scene(pane, x, y);

        // Set the new Scene to the Stage
        stg.setScene(scene);

        // Center the Stage
        centerStage(stg);
    }

    private void centerStage(Stage stage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
    }

    public static void main(String[] args) {
        launch();
    }
}