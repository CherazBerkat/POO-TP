package com.example.tp.Models;

import java.io.Serializable;

public class Exo implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private String consigne;
    private String materiel;
    private  int Score;
    //***********************************************CONSTRUCTEUR*****************************************************//
    public  Exo(String c, String m){
        consigne=c;
        materiel=m;
        Score=0;
    }
    //****************************************************GETTERS*****************************************************//
    public int getScore() {
        return Score;
    }

    public String getConsigne() {
        return consigne;
    }

    public String getMateriel() {
        return materiel;
    }

    //****************************************************SETTERS*****************************************************//
    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public void setScore(int score) {
        if (score >=1 && score <=10)
            Score = score;
        else
            System.out.println("score non valide");
    }
    //************************************************* METHODS ******************************************************//
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exo other = (Exo) obj;
        return consigne.equals(other.consigne) && materiel.equals(other.materiel);
    }
    
}
