package com.example.tp.Models;

import java.io.Serializable;
import java.util.Objects;

public class Trouble implements Serializable {
    private String nom;
    private TypeTrouble type;

    public Trouble()
    {
    }

    public Trouble(String n, TypeTrouble t)
    {
        nom = n;
        type = t;
    }

    public void affichTrouble()
    {
        System.out.println("Le nom du trouble : "+nom+" et son type : "+type);
    }

    public String getNom(){return nom;}

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(TypeTrouble type) {
        this.type = type;
    }

    public TypeTrouble getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trouble other = (Trouble) obj;
        // Check for null values
        if (nom == null || type == null || other.nom == null || other.type == null) return false;
        return nom.equals(other.nom) && type.equals(other.type);
    }

    public int hashCode() {
        return Objects.hash(nom, type);
    }
}