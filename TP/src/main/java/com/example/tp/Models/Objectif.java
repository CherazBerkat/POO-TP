package com.example.tp.Models;

import java.io.Serializable;
import java.util.Scanner;

public class Objectif implements Serializable {
    private String nom;
    private TypeObjectif type;
    private int note;
    public Objectif(String n, TypeObjectif t)
    {
        nom = n;
        type = t;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public TypeObjectif getType() {
        return type;
    }

    public void setType(TypeObjectif type) {
        this.type = type;
    }

    public void evaluer(int n)
    {
        if(n<=5 && n>=1)
           note=n;
        else
            System.out.println("Note non valide");
    }
}