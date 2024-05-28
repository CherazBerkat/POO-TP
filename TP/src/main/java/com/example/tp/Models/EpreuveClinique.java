package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class EpreuveClinique implements Serializable {
    //************************************************* LES ATTRIBUTS ******************************************************//
    private String observations;
    private ArrayList<SerieQuestion> serieQuestions= new ArrayList<>();
    private  ArrayList<SerieExo> serieExercices=new ArrayList<>() ;

    //******************************************************** GETTERS *************************************************//
    public String getObservations(){
        return observations;
    }

    public ArrayList<SerieExo> getSerieExercices() {
        return serieExercices;
    }

    public ArrayList<SerieQuestion> getSerieQuestions() {
        return serieQuestions;
    }
    //**************************************************** SETTER *****************************************************//
    public void setObservations(String observations) {
        this.observations = observations;
    }
    //**************************************************** SETTER *****************************************************//
    public void ajouterSerieQuestions(SerieQuestion s)
    {
        serieQuestions.add(s);
    }

    public void ajouterSerieExercices(SerieExo s)
    {
        serieExercices.add(s);
    }
    //************************************************* METHODS ******************************************************//
    public void deleteSerieQuestionsIndx (int index){
        if (index >= 0 && index < serieQuestions.size()) {
            serieQuestions.remove(index);
        } else {
            System.out.println("Invalid index. No Serie Exos deleted.");
        }
    }
}