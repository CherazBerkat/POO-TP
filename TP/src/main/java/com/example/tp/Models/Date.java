package com.example.tp.Models;

public class Date
{
    private int jour;
    private int mois;
    private int annee;

    public Date(int j, int m, int a)
    {
        jour = j;
        mois = m;
        annee = a;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }
}