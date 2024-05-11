import java.util.Scanner;
public class Consultation extends RendezVous {
    private final String dureeEnfant="2h30min";
    private final String dureeAdulte="1h30min";
    private String nom;
    private String prenom;
    private int age;
    private boolean adult;

    public Consultation(Date d, Heure h, BO bo, String n, String p, int a, boolean ad)
    {
        super(d,h,bo);
        nom = n;
        prenom = p;
        age = a;
        adult = aa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDureeEnfant() {
        return dureeEnfant;
    }

    public String getDureeAdulte() {
        return dureeAdulte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
            this.adult = adult;
    }

    public void programmerRendezVous()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du patient");
        nom=sc.nextLine();
        System.out.println("Entrer le prenom du patient");
        prenom=sc.nextLine();
        System.out.println("Entrer l'age du patient");
        age=sc.nextInt();
        System.out.println("Est-ce-que le patient est : 0-enfant 1-adulte ?");
        adult=sc.nextInt();
    }

    public void affichConsultation()
    {
        super();
        System.ou.println("Le nom : "+nom+" et le prenom : "+prenom+" l'age : "+age+" adulte? : "+adult);
    }
}