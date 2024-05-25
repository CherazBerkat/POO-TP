package com.example.tp.Models;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
public class AnamneseEnfant extends Anamnese implements Serializable{

    //************************************************* METHODS ******************************************************//
    public void ajouterQuestion(QuestionAnam q) {
        if (q instanceof QuestionAnamEnfant) {
            questions.add(q);
        }
    }
}