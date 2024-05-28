package com.example.tp.Models;

import java.io.Serializable;

public class Objectif implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private String nom;
    private TypeObjectif type;
    private int note;
    //***********************************************CONSTRUCTEUR*****************************************************//
    public Objectif(String n, TypeObjectif t)
    {
        nom = n;
        type = t;
    }
    //****************************************************GETTERS*****************************************************//
    public String getNom() {
        return nom;
    }

    public int getNote() {
        return note;
    }
    public TypeObjectif getType() {
        return type;
    }

    //****************************************************SETTERS*****************************************************//

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(TypeObjectif type) {
        this.type = type;
    }

    //************************************************* METHODS ******************************************************//
    public void evaluer(int n)
    {
        if(n<=5 && n>=1)
           note=n;
        else
            System.out.println("Note non valide");
    }
}