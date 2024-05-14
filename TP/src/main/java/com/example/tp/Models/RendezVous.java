package com.example.tp.Models;
import java.time.*;
import java.util.Date;
public abstract class RendezVous
{
    private LocalDate date;
    private LocalTime heure;
    //private BO bo;

    public abstract void programmerRendezVous();
    /*public void affichRendezVous()
    {
        System.out.println("date : "+date+" heure : "+heure+"\n");
      //  bo.affichBO();// ya pas affiche BO dans Bo marakich dayratha.
    }*/
}