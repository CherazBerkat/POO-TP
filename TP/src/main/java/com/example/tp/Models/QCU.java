package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QCU extends Question implements Serializable {
   /* private ArrayList<String> propos=new ArrayList<>();
    private  String juste ;*/
   private Map<String,Integer> propos =new HashMap<>();

    public  QCU (String t){
        super(t);
    }

    public Map<String,Integer> getPropos(){
        return propos;
    }

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

  /*  public void setJuste(String juste) {
        this.juste = juste;
    }

    public String getJuste() {
        return juste;
    }
    public void deletePropo (String c){
        ArrayList<String> toRemove= new ArrayList<>();
        for (String propo : propos){
            if(propo==c){
                toRemove.add(propo);
            }
        }
        propos.removeAll(toRemove);
    }
    public void deletePropoIndex(int index) {
        if (index >= 0 && index < propos.size()) {
            propos.remove(index);
        } else {
            System.out.println("Invalid index. No Proposition deleted.");
        }
    }
    public  void addPropo (String c){
        propos.add(c);
    }*/
}
