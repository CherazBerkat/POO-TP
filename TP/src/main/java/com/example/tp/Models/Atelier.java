package com.example.tp.Models;

import java.util.Scanner;

public class Atelier extends RendezVous {
    private String thematique;
   // private Patient[] patients;///should be integers array list

   /* public Atelier(Date d, Heure h, BO bo, String t) //Rendez vous n'a pas de constructeur marakich dayratalha.
    {
        super(d,h,bo);
        thematique = t;
        patients = new Patient[50];
    }*/

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public void afficherPatients()
    {

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
          //  patients[i] = sc.nextInt();
        }
    }
}
