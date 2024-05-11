public class FicheSuivi {
    private Objectif[] objectifs = new Objectif[100];
    private int nbObjectifs;
    private boolean objectifsAttient;

    public void ajouterObjectif(Objectif o)
    {
        objectifs[nbObjectifs]=o;
        nbObjectifs++;
    }
    public void affichObjectifs()
    {
        for(int i=0; i<nbObjectifs; i++)
        {
            objectifs[i].affichObjectif();
        }
    }
    public void evaluerObjectifs()
    {
        for(int i=0; i<nbObjectifs; i++)
        {
            objectifs[i].evaluerObjectif();
        }
    }
}