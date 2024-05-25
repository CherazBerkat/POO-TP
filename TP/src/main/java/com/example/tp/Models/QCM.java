package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QCM extends Question implements Serializable {
    private Map<String,Integer> choix =new HashMap<>();


    public QCM (String t){
        super(t);
    }

    public Map<String,Integer> getChoix(){
        return choix;
    }

    public  void addChoix (String c,boolean correct){
        if(correct)
           choix.put(c,1);
        else
            choix.put(c,0);
    }

  /*  public  void addChoix (String c){
        choix.add(c);
    }
    public void addCorrect (String c){
        correctes.add(c);
    }
    public void deleteChoix (String c){
        ArrayList<String> toRemove= new ArrayList<>();
        for (String choix : choix){
            if(choix==c){
                toRemove.add(choix);
            }
        }
        choix.removeAll(toRemove);
    }
    public void deleteCorrecte (String c){
        ArrayList<String> toRemove= new ArrayList<>();
        for (String choix : correctes){
            if(choix==c){
                toRemove.add(choix);
            }
        }
        correctes.removeAll(toRemove);
    }
    public void deleteChoixIndex(int index) {
        if (index >= 0 && index < choix.size()) {
            choix.remove(index);
        } else {
            System.out.println("Invalid index. No choix deleted.");
        }
    }
    public void deleteCorrectIndex(int index) {
        if (index >= 0 && index < correctes.size()) {
            correctes.remove(index);
        } else {
            System.out.println("Invalid index. No choix deleted.");
        }
    }*/
}
