
package com.example.tp.Models;

import java.io.Serializable;
import java.util.Scanner;
import java.time.*;
public class SeanceSuivi extends RendezVous implements Serializable {
    private int numeroDossier;
    private Deroulement deroulement;

    public SeanceSuivi(LocalDate d, LocalTime h, int n)
    {
        super(d,h);
        numeroDossier = n;
    }

    public Deroulement getDeroulement() {
        return deroulement;
    }

    public void setDeroulement(Deroulement deroulement) {
        this.deroulement = deroulement;
    }

    public int getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(int numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public void programmerRendezVous()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du numero de dossier du patient");
        numeroDossier=sc.nextInt();
        System.out.println("Entrer la Facon de deroulement du rendez-vous");
        deroulement=Deroulement.valueOf(sc.nextLine());
    }
}
