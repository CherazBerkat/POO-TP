package com.example.tp.Models;
import java.io.Serializable;
import java.time.*;
import java.util.Date;
public abstract class RendezVous implements Serializable {
    //************************************************* LES ATTRIBUTS ******************************************************//
    private LocalDate date;
    private LocalTime heure;
    private BO bo;
    //***********************************************CONSTRUCTEUR*****************************************************//
    public RendezVous(LocalDate d, LocalTime h)
    {
        date=d;
        heure=h;
    }
    //****************************************************GETTERS*****************************************************//
    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeure() {
        return heure;
    }
    //****************************************************SETTERS*****************************************************//
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public abstract void programmerRendezVous();

    public void affichRendezVous()
    {
        System.out.println("la date : "+date+" et l'heure : "+heure);
    }
}