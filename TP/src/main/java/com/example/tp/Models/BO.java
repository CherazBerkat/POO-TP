package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class BO implements Serializable {

    //***********************************************LES ATTRIBUTS****************************************************//
    private Diagnostic diagnostic;
    private ArrayList<EpreuveClinique> epreuveClinique = new ArrayList<>();
    private String projetTherapeutique;

    //***********************************************CONSTRUCTEUR*****************************************************//
    public BO(String p)
    {
        projetTherapeutique = p;
    }
    public BO (){}

    //****************************************************SETTERS*****************************************************//
    public  void setDiagnostic(Diagnostic d){
        diagnostic=d;
    }

    public void setProjetTherapeutique(String projetTherapeutique) {
        this.projetTherapeutique = projetTherapeutique;
    }
    //****************************************************GETTERS*****************************************************//

    public String getProjetTherapeutique()
    {
        return projetTherapeutique;
    }

    public ArrayList<EpreuveClinique> getEpreuveClinique() {
        return epreuveClinique;
    }

    public  Diagnostic getDiagnostic(){
        return diagnostic;
    }

    //************************************************* METHODS ******************************************************//
    public void ajouterEpreuveClinique(EpreuveClinique ec)
    {
        epreuveClinique.add(ec);
    }
    public void deleteEpreuveClinique(int ind){
        if (ind >= 0 && ind < epreuveClinique.size())
            epreuveClinique.remove(ind);
        else System.out.println("Index non valid , No question has been removed");
    }
}