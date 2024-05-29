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
import java.time.LocalDate;
import java.util.Locale;

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
/*
        //creer deux anamneses
        orthophonist.addAnamnese(new AnamneseAdulte());
        orthophonist.addAnamnese(new AnamneseEnfant());
        Anamnese anam=orthophonist.getAnamneses().get(0);
        String txt;
        for (int i=0;i<=10;i++){
            txt="text"+i;
            anam.ajouterQuestion(new QuestionAnamAdult(txt,TypeAnamneseAdulte.HISTOIREDEMALADIE));
        }
        Anamnese anam2=orthophonist.getAnamneses().get(1);
        for (int i=0;i<=10;i++){
            txt="text"+i;
            anam2.ajouterQuestion(new QuestionAnamEnfant(txt,TypeAnamneseEnfant.DEVELOPPEMENTLANGAGIER));
        }
        //creer un Serie de questions
        orthophonist.addSerieQuestions(new SerieQuestion("nom1", "capacite1"));
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
        sq.addQuestion(qcu);
        //creer un serie D'exercice
        orthophonist.addSerieExos(new SerieExo("nom1", "capacite1"));
        SerieExo s=orthophonist.getSerieExos().get(0);
        for (int i=0;i<=5;i++){
            s.addExo(new Exo("consigne0","materiel0"));
        }
        //creer des troubles
        TypeTrouble troubleType1 = TypeTrouble.DEGLUTITION;
        TypeTrouble troubleType2 = TypeTrouble.NEURODEVELOPPEMENTAUX;
        TypeTrouble troubleType3 = TypeTrouble.COGNITIFS;

        Trouble T1=new Trouble("Trouble1",troubleType1);
        Trouble T2=new Trouble("Trouble2",troubleType2);
        Trouble T3=new Trouble("Trouble3",troubleType3);
        Trouble T4=new Trouble("Trouble4",troubleType3);
        Trouble T13=new Trouble("Touble13",troubleType3);
        //creer des diagnostiques et ajouter les troubles
        Diagnostic dg11=new Diagnostic();
        dg11.ajouterTrouble(T1);
        dg11.ajouterTrouble(T2);
        dg11.ajouterTrouble(T3);
        Diagnostic dg12=new Diagnostic();
        dg12.ajouterTrouble(T1);
        dg12.ajouterTrouble(T2);
        dg12.ajouterTrouble(T13);
        Diagnostic dg21=new Diagnostic();
        dg21.ajouterTrouble(T1);
        dg21.ajouterTrouble(T2);
        dg21.ajouterTrouble(T3);
        Diagnostic dg22=new Diagnostic();
        dg22.ajouterTrouble(T1);
        dg22.ajouterTrouble(T2);
        dg22.ajouterTrouble(T13);
        dg22.ajouterTrouble(T4);
       //creer des objectifs
        Objectif obj1=new Objectif("objectif1",TypeObjectif.COURTTERME);
        Objectif obj2=new Objectif("objectif1",TypeObjectif.LONGTERME);
        Objectif obj3=new Objectif("objectif1",TypeObjectif.MOYENTERME);
        //creer une fiche de suivi et ajouter les objectifs
        FicheSuivi f=new FicheSuivi();
        f.ajouterObjectif(obj1);
        f.ajouterObjectif(obj2);
        f.ajouterObjectif(obj3);
        //creer des premiers BOs
        PremierBO pb1=new PremierBO(anam);
        PremierBO pb2=new PremierBO(anam2);
        //creer des epreuves et ajouter des series
        EpreuveClinique ep1=new EpreuveClinique();
        EpreuveClinique ep2=new EpreuveClinique();
        ep1.ajouterSerieQuestions(orthophonist.getSerieQuestions().get(0));
        ep1.ajouterSerieExercices(orthophonist.getSerieExos().get(0));
        ep2.ajouterSerieQuestions(orthophonist.getSerieQuestions().get(0));
        ep2.ajouterSerieExercices(orthophonist.getSerieExos().get(0));
        //creer des BOs
        BO b12=new BO();
        BO b11=new BO();
        BO b21=new BO();
        BO b22=new BO();
        //ajouter data au BOs
        b11.setDiagnostic(dg11);
        b12.setDiagnostic(dg12);
        b21.setDiagnostic(dg21);
        b22.setDiagnostic(dg22);
        b11.ajouterEpreuveClinique(ep1);
        b11.ajouterEpreuveClinique(ep2);
        b12.ajouterEpreuveClinique(ep1);
        b12.ajouterEpreuveClinique(ep2);
        b21.ajouterEpreuveClinique(ep1);
        b21.ajouterEpreuveClinique(ep2);
        b22.ajouterEpreuveClinique(ep1);
        b22.ajouterEpreuveClinique(ep2);
        b11.setProjetTherapeutique("projet Therapeutique");
        b12.setProjetTherapeutique("projet Therapeutique");
        b21.setProjetTherapeutique("projet Therapeutique");
        b22.setProjetTherapeutique("projet Therapeutique");
        //creer des patients
        Enfant enfant=new Enfant("nom1","prenom1","06512443",LocalDate.of(2023, 5, 28),"Alger","2CP","06542153");
        Adult adult=new Adult("nom2","prenom2","06512443",LocalDate.of(2000, 5, 28),"Alger","Doctorant","Proffesseur");
       //creer des dossiers
        Dossier d1=new Dossier();
        Dossier d2=new Dossier();
        //ajouter data aux dossiers
        d1.setPatient(enfant);
        d2.setPatient(adult);

        d1.ajouterFicheSuivi(f);
        d2.ajouterFicheSuivi(f);

        d1.ajouterBO(b11);
        d1.ajouterBO(b12);
        d2.ajouterBO(b21);
        d2.ajouterBO(b22);

        d1.ajouterBO(pb1);
        d2.ajouterBO(pb2);
        //ajouter les dossiers a l'objet orthophonist
        orthophonist.addDossier(d1);
        orthophonist.addDossier(d2);*/



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