package com.example.tp.Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Adult extends Patient implements Serializable {

    //***********************************************LES ATTRIBUTS****************************************************//
    private String diplome;
    private String prof;

    //***********************************************CONSTRUCTEUR*****************************************************//
    public Adult (String n, String p, String t, LocalDate d, String l,String dp,String pf){
        super(d,l,n,p,t);
        diplome=dp;
        prof=pf;
    }

    //****************************************************GETTERS*****************************************************//
    public String getDiplome() {
        return diplome;
    }

    public String getProf() {
        return prof;
    }

    //****************************************************SETTERS*****************************************************//
    public void setProf(String prof) {
        this.prof = prof;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
}
