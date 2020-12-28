package readability;

public class CLScore extends Readability {

    @Override
    public float compute(LexicalUnits units) {
        setScore(0.0588f * (units.getChars()/units.getWords()) * 100f - 0.296f * (units.getSentences()/units.getWords()) * 100f - 15.8f);
        return getScore();
    }
}
