import java.util.Scanner;
public class Objectif {
    private String nom;
    private TypeObjectifs type;
    private int note;
    public Objectif(String n, TypeObjectifs t)
    {
        nom = n;
        type = t;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public TypeObjectifs getType() {
        return type;
    }

    public void setType(TypeObjectifs type) {
        this.type = type;
    }

    public void evaluer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer la note entre 1 et 5 que vous voulez attribuer");
        nom=sc.nextInt();
    }
}