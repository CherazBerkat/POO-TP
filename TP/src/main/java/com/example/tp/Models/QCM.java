package com.example.tp.Models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class QCM extends Question implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private Map<String,Integer> choix =new HashMap<>();
    //***********************************************CONSTRUCTEUR*****************************************************//
    public QCM (String t){
        super(t);
    }
    //****************************************************GETTERS*****************************************************//
    public Map<String,Integer> getChoix(){
        return choix;
    }
    //************************************************* METHODS ******************************************************//
    public  void addChoix (String c,boolean correct){
        if(correct)
           choix.put(c,1);
        else
            choix.put(c,0);
    }

}
