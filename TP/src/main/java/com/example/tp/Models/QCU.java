package com.example.tp.Models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class QCU extends Question implements Serializable {
    //************************************************* LES ATTRIBUTS ******************************************************//
   private Map<String,Integer> propos =new HashMap<>();
    //***********************************************CONSTRUCTEUR*****************************************************//
    public  QCU (String t){
        super(t);
    }
    //****************************************************GETTERS*****************************************************//
    public Map<String,Integer> getPropos(){
        return propos;
    }
    //****************************************************METHODS*****************************************************//
    public void addPropo(String c, boolean correct) {
        if (correct) {
            // If correct is true, set all values to 0
            propos.replaceAll((key, value) -> 0);
            // Then set the value of the provided key to 1
            propos.put(c, 1);
        } else {
            // If correct is false, simply put the provided key with the value 0
            propos.put(c, 0);
        }
    }

}
