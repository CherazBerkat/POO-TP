package com.example.tp.Models;
import java.io.Serializable;
import java.time.LocalDate;
public class Patient extends Person implements Serializable {
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private int numDoss;

    public Patient (LocalDate date ,String lieu , String n ,String p, String t){
        super(n,p,t);
       dateNaissance = date;
       lieuNaissance=lieu;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        lieuNaissance = lieuNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public int getNumDoss() {
        return numDoss;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setNumDoss(int numDoss) {
        this.numDoss = numDoss;
    }
}
