package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class FicheSuivi implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private ArrayList<Objectif> objectifs = new ArrayList<>();

    public ArrayList<Objectif> getObjectifs(){
        return objectifs;
    }

    //************************************************* METHODS ******************************************************//

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