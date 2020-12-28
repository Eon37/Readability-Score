package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalUnits {

    private float sentences = 0;
    private float words = 0;
    private float chars = 0;
    private float sylls = 0;
    private float polysylls = 0;

    private Matcher m;

    public void countUnits(String line) {
        words += countWords(line);
        sentences += countSentences(line);
        chars += countChars(line);
        sylls += countSyllables(line);
        polysylls = countPolysyllables(line);
    }

    private float countWords(String line) {
        return line.split("\\s+").length;
    }

    private float countChars(String line) {
        m = Pattern.compile("\\S").matcher(line);
        return m.results().count();
    }

    private float countSentences(String line) {
        m = Pattern.compile("[.?!]").matcher(line);
        return (line.matches("^.*([^.!?])$")) ? m.results().count() + 1 : m.results().count();
    }

    private float countSyllables(String line) {
        m = Pattern.compile("(([aeiouyAEIOUY])*([aiouyAIOUY] |[aiouyAIOUY]$|[aiouyAIOUY]\\w|e\\w)|[tT]he|[wW]e|E)").matcher(line);
        float cnt = m.results().count();
        return cnt == 0 ? 1 : cnt;
    }

    private float countPolysyllables(String line) {
        String[] words = line.split("\\s+");
        float cnt = polysylls;
        for (String word : words) {
            if (word.matches("(\\()?[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTWVXZ]*([aeiouyAEIOUY]+[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTWVXZ]+|[yO]){3,}(\\w+)?([.!?,)])?")) {
                System.out.println(word);
                cnt++;
            }
        }
        return cnt;
    }

    public float getSentences() {
        return sentences;
    }

    public float getWords() {
        return words;
    }

    public float getChars() {
        return chars;
    }

    public float getSylls() {
        return sylls;
    }

    public float getPolysylls() {
        return polysylls;
    }
}
