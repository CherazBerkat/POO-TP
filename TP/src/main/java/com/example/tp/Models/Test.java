package com.example.tp.Models;

import java.io.Serializable;

public abstract class Test implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private String nom;
    private String capacite;
    private String conclusion;
    //***********************************************CONSTRUCTEUR*****************************************************//
    public Test (String n,String c){
        nom=n;
        capacite=c;
    }
    //****************************************************GETTERS*****************************************************//
    public String getNom() {
        return nom;
    }
    public String getCapacite() {
        return capacite;
    }

    public String getConclusion() {
        return conclusion;
    }
    //****************************************************SETTERS*****************************************************//
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public abstract float calculerScoreTotale();

}
