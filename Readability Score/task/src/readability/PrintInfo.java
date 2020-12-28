package readability;

public class PrintInfo {

    public static void printCounts(LexicalUnits units) {
        System.out.println("Words: " + units.getWords() + "\n" +
                "Sentences: " + units.getSentences() + "\n" +
                "Characters: " + units.getChars() + "\n" +
                "Syllables: " + units.getSylls() + "\n" +
                "Polysyllables: " + units.getPolysylls() + "\n");
    }

    public static void printScore(String abr, float score) {
        System.out.println(Readability.ABBRIVS.get(abr) + ": " + String.format("%.2f", score - 0.005) +
                " (about " + (score < 14 ? Readability.SCORE_AGE[Math.round(score) - 1] : "24+") +
                " year olds).");
    }

    public static void printAge(float score) {
        System.out.println("This text should be understood by " + Readability.SCORE_AGE[Math.round(score)] + " year olds.");
    }

    public static void printAge(float ARIscore, float FKscore, float SMOGscore, float CLscore) {
        System.out.println("This text should be understood in average by " +
                (float)(Readability.SCORE_AGE[Math.round(ARIscore) - 1] + Readability.SCORE_AGE[Math.round(FKscore) - 1] +
                        Readability.SCORE_AGE[Math.round(SMOGscore) - 1] + Readability.SCORE_AGE[Math.round(CLscore) - 1])/Readability.ABBRIVS.size() +
                " year olds.");
    }
}
