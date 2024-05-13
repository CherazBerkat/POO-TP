package com.example.tp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    public static void main(String[] args) {
        launch();
    }
}