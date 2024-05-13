package com.example.tp.Models;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import static com.example.tp.HelloApplication.*;

public class Ortho implements  Serializable{
    private String nom;
    private String prenom;
    private String tel;
    private String mail;
    private String passwd;
    private String userName;
    private ArrayList<SerieExo> serieExos =new ArrayList<>();
    private ArrayList<SerieQuestion> serieQuestions=new ArrayList<>();
    private  ArrayList<Dossier> dossiers=new ArrayList<>();
    private ArrayList<Anamnese> anamneses=new ArrayList<>();
    private ArrayList<RendezVous> rendezVous=new ArrayList<>();





    public Ortho (String n,String p,String t,String m,String pd){
        nom=n;
        prenom=p;
        tel=t;
        mail=m;
        passwd=pd;
    }
    public Ortho(){}

    /**************************************************************************************************/
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd(){
        return passwd;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
     public String getUserNAme(){
        return userName;
     }

     /***********************************************************************************************/
    public void addSerieExos(SerieExo s){
        serieExos.add(s);
    }
    public void addSerieQuestions(SerieQuestion s){
        serieQuestions.add(s);
    }
    public void addAnamnese(Anamnese s){
        anamneses.add(s);
    }
    public void addDossier(Dossier s){
        dossiers.add(s);
    }
    public void addRendezVous(RendezVous s){
        rendezVous.add(s);
    }
    public void deleteRendezVousIndx (int index){
        if (index >= 0 && index < rendezVous.size()) {
            rendezVous.remove(index);
        } else {
            System.out.println("Invalid index. No rendez-vous deleted.");
        }
    }
    public void deleteDossierIndx (int index){
        if (index >= 0 && index < dossiers.size()) {
            dossiers.remove(index);
        } else {
            System.out.println("Invalid index. No dossier deleted.");
        }
    }
    public void deleteAnamneseIndx (int index){
        if (index >= 0 && index < anamneses.size()) {
            anamneses.remove(index);
        } else {
            System.out.println("Invalid index. No Anamnese deleted.");
        }
    }

    public void deleteSerieExosIndx (int index){
        if (index >= 0 && index < serieExos.size()) {
            serieExos.remove(index);
        } else {
            System.out.println("Invalid index. No Serie Exos deleted.");
        }
    }

    public void deleteSerieQuestionsIndx (int index){
        if (index >= 0 && index < serieQuestions.size()) {
            serieQuestions.remove(index);
        } else {
            System.out.println("Invalid index. No Serie Exos deleted.");
        }
    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(FILE_PATH))) {
            out.writeObject(orthophonist);
            System.out.println("data is saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}