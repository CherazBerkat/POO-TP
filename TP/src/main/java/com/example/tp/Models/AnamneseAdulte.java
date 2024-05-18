package com.example.tp.Models;
import java.util.HashMap;
import java.io.Serializable;
public class AnamneseAdulte extends Anamnese implements Serializable{
    private HashMap<TypeAnamneseAdulte,String> questions = new HashMap<>();

    public void ajouterQuestion(TypeAnamneseAdulte type, String question){
        questions.put(type,question);
    }
   /* public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AnamneseAdulte other = (AnamneseAdulte) obj;
        return questions.equals(other.questions);
    }*/

}