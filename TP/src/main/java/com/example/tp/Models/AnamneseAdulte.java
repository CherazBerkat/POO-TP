package com.example.tp.Models;
import java.util.HashMap;
import java.io.Serializable;
public class AnamneseAdulte extends Anamnese implements Serializable{
    private HashMap<TypeAnamneseAdulte,String> questions = new HashMap<>();

    public void ajouterQuestion(TypeAnamneseAdulte type, String question){
        questions.put(type,question);
    }

}