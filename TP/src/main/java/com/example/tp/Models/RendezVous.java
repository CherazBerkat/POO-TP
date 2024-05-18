package com.example.tp.Models;
import java.io.Serializable;
import java.time.*;
import java.util.Date;
public abstract class RendezVous implements Serializable
{
    private LocalDate date;
    private LocalTime heure;
    private BO bo;

    public RendezVous(LocalDate d, LocalTime h)
    {
        date=d;
        heure=h;
    }
    public abstract void programmerRendezVous();
}