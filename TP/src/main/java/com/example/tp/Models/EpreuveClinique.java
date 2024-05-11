public class EpreuveClinique {
    private String observations;
    private SerieQuestions serieQuestions;
    private SerieExercices serieExercices;

    public EpreuveClinique(String o, SerieQuestions q, SerieExercices e)
    {
        observations = o;
        serieExercices = e;
        serieQuestions = q;
    }
}