package com.example.tp.Models;
import java.io.Serializable;
import java.util.ArrayList;
public class SerieExo extends Test implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private ArrayList<Exo> exos = new ArrayList<>();
    //***********************************************CONSTRUCTEUR*****************************************************//
    public SerieExo(String n,String c){
        super(n,c);
    }

    //****************************************************GETTERS*****************************************************//
    public ArrayList<Exo> getExos(){
        return exos;
    }

    //************************************************* METHODS ******************************************************//
    public void addExo(Exo exo) {
        exos.add(exo);
    }

    // Method to delete an Exo from the list based on index
    public void deleteExoIndx(int index) {
        if (index >= 0 && index < exos.size()) {
            exos.remove(index);
        } else {
            System.out.println("Invalid index. No Exo deleted.");
        }
    }

    public float calculerScoreTotale(){
        int sum=0;
        int counter=0;
        float sumtot=0;
        int compt=0;
        ArrayList<Exo> exosNew = new ArrayList<>(exos);
        for (int i = 0; i < exosNew.size(); i++) {
            sum = 0;
            counter = 0;
            Exo exo = exosNew.get(i);
            for (Exo exo2 : exosNew) {
                if (exo.equals(exo2)) {
                    sum += exo2.getScore();
                    counter++;
                }
            }
            sumtot += (sum / counter);
            // Remove the processed elements from exosNew
            exosNew.removeIf(exo2 -> exo.equals(exo2));
            compt++;
        }
        return sumtot/compt;
    }


}
