package com.example.tp.Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Adult extends Patient implements Serializable {
    private String diplome;
    private String prof;
    public Adult (String n, String p, String t, LocalDate d, String l,String dp,String pf){
        super(d,l,n,p,t);
        diplome=dp;
        prof=pf;
    }
    public String getDiplome() {
        return diplome;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
}
