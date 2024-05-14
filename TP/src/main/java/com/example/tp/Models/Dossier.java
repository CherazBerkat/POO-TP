package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;
public class Dossier implements Serializable {
    private static int num=0;
    private int numeroDossier;
    private ArrayList<RendezVous> rendezVous = new ArrayList<>();
    private ArrayList<BO> BOs = new ArrayList<>();
    private ArrayList<FicheSuivi> ficheSuivis = new ArrayList<>();

    public Dossier()
    {
        numeroDossier = num;
        num++;
    }

    public int getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(int numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public void ajouterRendezVous(RendezVous rv)
    {
        rendezVous.add(rv);
    }

    public void ajouterBO(BO bo)
    {
        BOs.add(bo);
    }

    public void ajouterFicheSuivi(FicheSuivi f)
    {
        ficheSuivis.add(f);
    }

}