package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class FicheSuivi implements Serializable {
    private ArrayList<Objectif> objectifs = new ArrayList<>();

    public ArrayList<Objectif> getObjectifs(){
        return objectifs;
    }

    private boolean objectifsAttient;

    public void ajouterObjectif(Objectif o)
    {
        objectifs.add(o);
    }

    public void deleteObjectif (int index){
        if (index >= 0 && index < objectifs.size()) {
            objectifs.remove(index);
        } else {
            System.out.println("Invalid index. No objectif deleted.");
        }
    }

}