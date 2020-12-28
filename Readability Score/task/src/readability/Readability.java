package readability;

import java.util.HashMap;

public abstract class Readability {
    public final static byte[] SCORE_AGE = new byte[] {6, 7, 9,
            10, 11, 12,
            13, 14, 15,
            16, 17, 18,
            24, 24};

    public final static HashMap<String, String> ABBRIVS;
    static {
        ABBRIVS = new HashMap<String, String>();
        ABBRIVS.put("ARI", "Automated Readability Index");
        ABBRIVS.put("FK", "Flesch–Kincaid readability tests");
        ABBRIVS.put("SMOG", "Simple Measure of Gobbledygook");
        ABBRIVS.put("CL", "Coleman–Liau index");
    }

    private float score;

    protected void setScore(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public abstract float compute(LexicalUnits units);
}
