package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class BO implements Serializable {
    private Diagnostic diagnostic;
    private ArrayList<EpreuveClinique> epreuveClinique = new ArrayList<>();
    private String projetTherapeutique;
    public BO(String p)
    {
        projetTherapeutique = p;
    }
    public BO (){}
    public String getProjetTherapeutique()
    {
        return projetTherapeutique;
    }

    public ArrayList<EpreuveClinique> getEpreuveClinique() {
        return epreuveClinique;
    }

    public void setProjetTherapeutique(String projetTherapeutique) {
        this.projetTherapeutique = projetTherapeutique;
    }

    public void ajouterEpreuveClinique(EpreuveClinique ec)
    {
        epreuveClinique.add(ec);
    }
    public  void setDiagnostic(Diagnostic d){
        diagnostic=d;
    }

    public  Diagnostic getDiagnostic(){
        return diagnostic;
    }

    public void deleteEpreuveClinique(int ind){
        if (ind >= 0 && ind < epreuveClinique.size())
            epreuveClinique.remove(ind);
        else System.out.println("Index non valid , No question has been removed");
    }

}