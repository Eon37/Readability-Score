package readability;

public class ARIScore extends Readability{

    @Override
    public float compute(LexicalUnits units) {
        setScore(4.71f * (units.getChars()/units.getWords()) + 0.5f * (units.getWords()/units.getSentences()) - 21.43f);
        return getScore();
    }
}
