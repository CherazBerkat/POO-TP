package com.example.tp.Models;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String nom ;
    private String prenom;
    private String tel;

    public Person (String n ,String p,String t){
        nom=n;
        prenom=p;
        tel=t;
    }
    public  Person (){}
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
