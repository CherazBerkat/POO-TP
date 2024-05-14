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
    public void ajouterEpreuveClinique(EpreuveClinique ec)
    {
        epreuveClinique.add(ec);
    }


}