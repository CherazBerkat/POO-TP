package com.example.tp.Models;
import java.util.HashMap;
import java.io.Serializable;
public class AnamneseEnfant extends Anamnese implements Serializable{
    private HashMap<TypeAnamneseEnfant,String> questions = new HashMap<>();

    public void ajouterQuestion(TypeAnamneseEnfant type, String question){
        questions.put(type,question);
    }
  /*  public boolean equals( Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AnamneseEnfant other = (AnamneseEnfant) obj;
        return questions.equals(other.questions);
    }*/
}