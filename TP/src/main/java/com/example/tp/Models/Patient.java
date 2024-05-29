package com.example.tp.Models;
import java.io.Serializable;
import java.time.LocalDate;
public class Patient implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private int numDoss;
    private String nom ;
    private String prenom;
    private String tel;
    //***********************************************CONSTRUCTEUR*****************************************************//
    public Patient (LocalDate date ,String lieu , String n ,String p, String t){
        nom=n;
        prenom=p;
        tel=t;
       dateNaissance = date;
       lieuNaissance=lieu;
    }
    //****************************************************GETTERS*****************************************************//
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public int getNumDoss() {
        return numDoss;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    //****************************************************SETTERS*****************************************************//
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        lieuNaissance = lieuNaissance;
    }
    public void setNumDoss(int numDoss) {
        this.numDoss = numDoss;
    }
}
