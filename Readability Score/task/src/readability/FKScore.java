package readability;

public class FKScore extends Readability{

    @Override
    public float compute(LexicalUnits units) {
        setScore(0.39f * (units.getWords()/units.getSentences()) + 11.8f * (units.getSylls()/units.getWords()) - 15.59f);
        return getScore();
    }
}
