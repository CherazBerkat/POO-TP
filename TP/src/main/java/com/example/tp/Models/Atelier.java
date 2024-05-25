package com.example.tp.Models;

import java.io.Serializable;
import java.util.Scanner;
import java.time.*;
import java.util.ArrayList;
public class Atelier extends RendezVous implements Serializable {
    private String thematique;
    private ArrayList<Integer>patients= new ArrayList<Integer>();///should be integers array list

    public Atelier(LocalDate d, LocalTime h, String t) //Rendez vous n'a pas de constructeur marakich dayratalha.
    {
        super(d, h);
        thematique = t;
    }
    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public void affichPatients() {
        for (int patient : patients) {
            //e.affichPatient();
        }
    }

    public void ajouterPatient(int id) {
        patients.add(id);
    }

    public void programmerRendezVous() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nombre des patients");
        n = sc.nextInt();
        System.out.println("Entrer la thematique de l'atelier");
        thematique = sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Entrer le numero de dossier du patient" + i);
            patients.add(sc.nextInt());
        }
    }
}