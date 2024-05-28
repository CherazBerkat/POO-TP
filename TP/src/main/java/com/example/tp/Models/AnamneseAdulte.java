package com.example.tp.Models;
import java.io.Serializable;


public class AnamneseAdulte extends Anamnese implements Serializable{

    //************************************************* METHODS ******************************************************//
    public void ajouterQuestion(QuestionAnam q) {
        if (q instanceof QuestionAnamAdult) {
            questions.add(q);
        }
    }

}