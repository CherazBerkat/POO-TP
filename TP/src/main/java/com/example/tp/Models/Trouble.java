package com.example.tp.Models;

public class Trouble {
    private String nom;
    private TypeTrouble type;

    public Trouble(String n, TypeTrouble t)
    {
        nom = n;
        type = type;
    }

    public void affichTrouble()
    {
        System.out.println("Le nom du trouble : "+nom+" et son type : "+type);
    }
}