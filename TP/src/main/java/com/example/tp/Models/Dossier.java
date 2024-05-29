
package com.example.tp.Models;

import java.io.Serializable;
import java.util.*;

public class Dossier implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private static int num=0;
    private int numeroDossier;
    private Patient patient;
    private ArrayList<RendezVous> rendezVous = new ArrayList<>();
    private ArrayList<BO> BOs = new ArrayList<>();
    private ArrayList<FicheSuivi> ficheSuivis = new ArrayList<>();

    //***********************************************CONSTRUCTEUR*****************************************************//
    public Dossier()
    {
        numeroDossier = num;
        num++;
    }
    //****************************************************GETTERS*****************************************************//
    public Patient getPatient() {
        return patient;
    }
    public int getNumeroDossier() {
        return numeroDossier;
    }
    public ArrayList<RendezVous> getRendezVous() {
        return rendezVous;
    }
    public ArrayList<BO> getBOs() {
        return BOs;
    }
    public ArrayList<FicheSuivi> getFicheSuivis() {
        return ficheSuivis;
    }


    //****************************************************SETTERS*****************************************************//
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //************************************************* METHODS ******************************************************//
    public void ajouterRendezVous(RendezVous rv)
    {
        rendezVous.add(rv);
    }

    public void ajouterBO(BO bo)
    {
        BOs.add(bo);
    }

    public void ajouterFicheSuivi(FicheSuivi f)
    {
        ficheSuivis.add(f);
    }

    public  void deleteRDV(int ind){
        if (ind >= 0 && ind < rendezVous.size())
            rendezVous.remove(ind);
        else System.out.println("Index non valid , No question has been removed");
    }

    public  void deleteBO(int ind){
        if (ind >= 0 && ind < BOs.size())
            BOs.remove(ind);
        else System.out.println("Index non valid , No question has been removed");
    }

    public  void deleteFiche(int ind){
        if (ind >= 0 && ind < ficheSuivis.size())
            ficheSuivis.remove(ind);
        else System.out.println("Index non valid , No question has been removed");
    }

    public Set<Trouble> allTroubles(){
        Set<Trouble> troubles = new HashSet<>();
        for (BO bo : BOs) {
            if (bo != null) { // Check if bo is not null
                Diagnostic diagnostic = bo.getDiagnostic();
                if (diagnostic != null) { // Check if diagnostic is not null
                    for (Trouble trouble : diagnostic.getTroubles()) {
                        if(!troubles.contains(trouble)){
                            troubles.add(trouble);
                        }
                    }
                }
            }
        }
        return troubles;
    }
}
