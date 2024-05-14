package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class EpreuveClinique implements Serializable {
    private String observations;
    private ArrayList<SerieQuestion> serieQuestions= new ArrayList<>();
    private  ArrayList<SerieExo> serieExercices=new ArrayList<>() ;

    public void ajouterSerieQuestions(SerieQuestion s)
    {
        serieQuestions.add(s);
    }

    public void ajouterSerieExercices(SerieExo s)
    {
        serieExercices.add(s);
    }
}