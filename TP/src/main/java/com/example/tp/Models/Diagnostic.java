public class Diagnostic
{
    private Trouble[] troubles = new Trouble[100];
    private int nbtrouble = 0;

    public void affichTroubles() {
        for (int i = 0; i < nbtrouble; i++) {
            System.out.println(troubles[i].affichTrouble());
        }
    }

    public void ajouterTrouble(Trouble t)
    {
        troubles[nbtrouble] = t;
        nbtrouble++;
    }
}