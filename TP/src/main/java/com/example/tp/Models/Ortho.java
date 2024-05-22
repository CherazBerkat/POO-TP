package com.example.tp.Models;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.tp.HelloApplication.*;

public class Ortho implements  Serializable{
    private String nom;
    private String prenom;
    private String tel;
    private String adr;
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
     public String getUserName(){
        return userName;
     }
     public void setAdr(String a){
        adr=a;
     }
     public String getAdr(){
        return adr;
     }
     public ArrayList<Anamnese> getAnamneses(){
        return anamneses;
     }
     public ArrayList<SerieExo> getSerieExos(){
        return serieExos;
     }
    public ArrayList<SerieQuestion> getSerieQuestions(){
        return serieQuestions;
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
        System.out.println("index: "+index);
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

    /****************************************************************************************************/
    public  void affichInfo(){
        System.out.println("Nom: "+nom);
        System.out.println("Prenom: "+prenom);
        System.out.println("Adress: "+adr);
        System.out.println("telephone: "+tel);
        System.out.println("email: "+mail);
        System.out.println("psswd: "+passwd);
        System.out.println("username: "+userName);
    }

    public Map<Trouble, Integer> countTroubles() {
        Map<Trouble, Integer> troubleCounts = new HashMap<>();

        for (Dossier doss : dossiers) {
            for (Trouble trouble : doss.allTroubles()){
                troubleCounts.put(trouble, troubleCounts.getOrDefault(trouble, 0) + 1);
            }
        }
        return troubleCounts;
    }

    public Map<Trouble, Float> countTroublesPercentages(Map<Trouble, Integer> ini) {
        Map<Trouble, Float> troublePercentages = new HashMap<>();
        int totalDossiers = dossiers.size();
        for (Map.Entry<Trouble, Integer> entry : ini.entrySet()) {
            Trouble trouble = entry.getKey();
            int count = entry.getValue();
            float percentage = (float) count / totalDossiers;
            troublePercentages.put(trouble, percentage);
        }

        return troublePercentages;
    }

}
