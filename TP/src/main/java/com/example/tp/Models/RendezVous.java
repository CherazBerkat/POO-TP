public abstract class RendezVous
{
    private Date date;
    private Heure heure;
    private final String duree="1h";
    private BO bo;

    public abstract void programmerRendezVous()
    {

    }
    public void affichRendezVous()
    {
        System.ou.println("date : "+date+" heure : "+heure+" duree : "+duree+"\n");
        bo.affichBO();
    }
}