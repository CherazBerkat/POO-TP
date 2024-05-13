package com.example.tp;

import java.io.Serializable;
import java.time.LocalDate;

public class Enfant extends Patient implements Serializable {
    private String classe;
    private String tel2;

    public Enfant ( String n, String p,String t,LocalDate d,String l,String c, String t2){
        super(d,l,n,p,t);
        classe=c;
        tel2=t2;
    }


    public String getClasse() {
        return classe;
    }

    public String getTel2() {
        return tel2;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

}
