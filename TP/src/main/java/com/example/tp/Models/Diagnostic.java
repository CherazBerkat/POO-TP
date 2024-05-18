package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;
public class Diagnostic implements Serializable
{
    private ArrayList<Trouble> troubles = new ArrayList<>();

    public void ajouterTrouble(Trouble t)
    {
        troubles.add(t);
    }

    public ArrayList<Trouble> getTroubles(){
        return troubles;
    }
}