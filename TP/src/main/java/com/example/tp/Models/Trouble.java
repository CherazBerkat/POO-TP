package com.example.tp.Models;

import java.io.Serializable;
import java.util.Objects;

public class Trouble implements Serializable {
    //************************************************* LES ATTRIBUTS ******************************************************//
    private String nom;
    private TypeTrouble type;
    //************************************************* LES CONSTRUCTEURS ******************************************************//
    public Trouble()
    {
    }

    public Trouble(String n, TypeTrouble t)
    {
        nom = n;
        type = t;
    }
    //****************************************************GETTERS*****************************************************//
    public String getNom(){return nom;}
    public TypeTrouble getType() {
        return type;
    }

    //****************************************************SETTERS*****************************************************//

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(TypeTrouble type) {
        this.type = type;
    }

    //************************************************* METHODS ******************************************************//
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