package com.example.tp.Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Enfant extends Patient implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private String classe;
    private String tel2;
    //***********************************************CONSTRUCTEUR*****************************************************//
    public Enfant ( String n, String p,String t,LocalDate d,String l,String c, String t2){
        super(d,l,n,p,t);
        classe=c;
        tel2=t2;
    }

    //****************************************************GETTERS*****************************************************//
    public String getClasse() {
        return classe;
    }

    public String getTel2() {
        return tel2;
    }

    //****************************************************SETTERS*****************************************************//
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }
    public void setClasse(String classe) {
        this.classe = classe;
    }

}
