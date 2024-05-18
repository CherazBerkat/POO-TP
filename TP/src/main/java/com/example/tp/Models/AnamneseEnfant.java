package com.example.tp.Models;
import java.util.HashMap;
import java.io.Serializable;
public class AnamneseEnfant extends Anamnese implements Serializable{
    private HashMap<TypeAnamneseEnfant,String> questions = new HashMap<>();

    public void ajouterQuestion(TypeAnamneseEnfant type, String question){
        questions.put(type,question);
    }

}