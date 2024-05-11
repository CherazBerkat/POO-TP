public class Heure {
   private int heures;
   private int minutes;
   private int secondes;

   public Heure(int h, int m, int s)
   {
       heures = h;
       minutes = m;
       secondes = s;
   }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSecondes() {
        return secondes;
    }

    public void setSecondes(int secondes) {
        this.secondes = secondes;
    }
}