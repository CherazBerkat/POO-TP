package com.example.tp.Models;

import java.io.Serializable;

public abstract class Test implements Serializable {
    private String nom;
    private String capacite;
    private String conclusion;
    public Test (String n,String c){
        nom=n;
        capacite=c;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public String getCapacite() {
        return capacite;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public abstract float calculerScoreTotale();
   // public  abstract void compteRendu();

}
