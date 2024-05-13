package com.example.tp;

import java.io.Serializable;

public class Exo implements Serializable {
    private String consigne;
    private String materiel;
    private  int Score;

    public  Exo(String c, String m){
        consigne=c;
        materiel=m;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exo other = (Exo) obj;
        return consigne.equals(other.consigne) && materiel.equals(other.materiel);
    }

    public int getScore() {
        return Score;
    }

    public String getConsigne() {
        return consigne;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public void setScore(int score) {
        Score = score;
    }
    public void afficher(){
        System.out.println("Consigne: "+consigne);
        System.out.println("Materiel: "+materiel);
        System.out.println("Score: "+Score);
    }
}
