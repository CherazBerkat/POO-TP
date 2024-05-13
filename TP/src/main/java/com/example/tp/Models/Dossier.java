package com.example.tp.Models;

public class Dossier {
    private static int num=0;
    private int numeroDossier;
    private RendezVous[] rendezVous = new RendezVous[1000];
    private int nbrv = 0;
    private BO[] bos = new BO[1000];
    private int nbbos = 0;
    private FicheSuivi[] fichesSuivis = new FicheSuivi[1000];
    private int nbfiches = 0;

    public Dossier()
    {
        numeroDossier = num;
        num++;
    }

    public int getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(int numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public void ajouterRendezVous(RendezVous rv)
    {
        rendezVous[nbrv] = rv;
        nbrv++;
    }

  /*  public void ajouterBO(BO bo)
    {
        rendezVous[nbbos] = bo;
        nbbo++;
    }*/ //jsp mais there is an error n it should be an array list michi tab

   /* public void ajouterFicheSuivi(FicheSuivi fiche)
    {
        rendezVous[nbfiches] = fiche;
        nbfiches++;
    }*/

  /*  public void affichRVs() {
        for (int i = 0; i < nbrv; i++) {
            System.out.println(rendezVous[i].affichRendezVous());
        }
    }*/

  /*  public void affichBOs() {
        for (int i = 0; i < nbbos; i++) {
            System.out.println(bos[i].affichBO());
        }
    }*/

   /* public void affichFiches() {
        for (int i = 0; i < nbfiches; i++) {
            System.out.println(fichesSuivis[i].affichFicheSuivi());
        }
    }*/
}