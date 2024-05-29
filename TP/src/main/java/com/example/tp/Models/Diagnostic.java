package com.example.tp.Models;
import java.io.Serializable;
import java.util.ArrayList;
public class Diagnostic implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private ArrayList<Trouble> troubles = new ArrayList<>();

    //****************************************************GETTERS*****************************************************//
    public ArrayList<Trouble> getTroubles(){
        return troubles;
    }

    public Trouble getTrouble(int ind){
        if (ind >= 0 && ind < troubles.size())
            return troubles.get(ind);
        else return null;
    }

    //************************************************* METHODS ******************************************************//
    public void ajouterTrouble(Trouble t)
    {
        troubles.add(t);
    }

    public  void deleteTrouble(int ind){
        if (ind >= 0 && ind < troubles.size())
            troubles.remove(ind);
        else System.out.println("Index non valid , No question has been removed");
    }

}
