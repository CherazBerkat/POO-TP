import java.*;
public class SeanceSuivi extends RendezVous {
    private int numeroDossier;
    private Deroulement deroulement;

    public SeanceSuivi(Date d, Heure h, BO bo, int n)
    {
        super(d,h,bo);
        numeroDossier = n;
    }

    public Deroulement getDeroulement() {
        return deroulement;
    }

    public void setDeroulement(Deroulement deroulement) {
        this.deroulement = deroulement;
    }

    public int getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(int numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public void programmerRendezVous()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du numero de dossier du patient");
        numeroDossier=sc.nextInt();
        System.out.println("Entrer la Facon de deroulement du rendez-vous");
        deroulement=valueof(sc.nextLine());
    }

    public void affichRendezVous()
    {
        super();
        System.ou.println("Le numero du dossier : "+numeroDossier+" et le deroulement de la seance : "+Deroulement);
    }
}
