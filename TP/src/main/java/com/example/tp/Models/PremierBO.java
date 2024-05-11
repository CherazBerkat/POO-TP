public class PremierBO extends BO {
    private Anamnese anamnese;
    public PremierBO(Diagnostic d, Epreuves Cliniques e, String p, Anamnese a)
    {
        super(d,e,p);
        anamnese = a;
    }

}