package com.example.tp;

import java.io.Serializable;
import java.util.ArrayList;

public class QCU extends Question implements Serializable {
    private ArrayList<String> propos=new ArrayList<>();
    private  String juste ;

    public  QCU (String t){
        super(t);
    }

    public void setJuste(String juste) {
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
    }
}
