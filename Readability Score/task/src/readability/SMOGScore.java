package readability;

public class SMOGScore extends Readability {

    @Override
    public float compute(LexicalUnits units) {
        setScore(1.043f * (float)Math.sqrt(units.getPolysylls() * (30/units.getSentences())) + 3.1291f);
        return getScore();
    }
}
