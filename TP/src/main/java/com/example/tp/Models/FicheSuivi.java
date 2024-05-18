package com.example.tp.Models;
public class FicheSuivi {
    private Objectif[] objectifs = new Objectif[100];
    private int nbObjectifs;
    private boolean objectifsAttient;

    public void ajouterObjectif(Objectif o)
    {
        objectifs[nbObjectifs]=o;
        nbObjectifs++;
    }
    public void affichObjectifs()
    {
        for(int i=0; i<nbObjectifs; i++)
        {
            // objectifs[i].affichObjectif(); method doesn't exist
        }
    }
    public void evaluerObjectifs()
    {
        for(int i=0; i<nbObjectifs; i++)
        {
            // objectifs[i].evaluerObjectif();
        }
    }
}