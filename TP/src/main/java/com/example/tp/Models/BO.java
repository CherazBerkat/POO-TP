package com.example.tp.Models;
public class BO {
    private Diagnostic diagnostic;
    private EpreuveClinique[] epreuveClinique = new EpreuveClinique[100];
    private int nbepreuves = 0;
    private String projetTherapeutique;
    public BO(String p)
    {
        projetTherapeutique = p;
    }
    public void ajouterEpreuveClinique(EpreuveClinique ec)
    {
        epreuveClinique[nbepreuves] = ec;
        nbepreuves++;
    }

    public void affichEpreuveClinique() {
        for (int i = 0; i < nbepreuves; i++) {
          //  System.out.println(epreuveClinique[i].affichEpreuveClinique()); makachha fe epreuve clinique
            //  }
    }


}
}