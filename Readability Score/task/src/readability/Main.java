package readability;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final static String TEXT_DIR = "Readability Score\\srcText\\";

    public static void main(String[] args) {
        File text = new File(TEXT_DIR + args[0]);

        try (Scanner fileScanner = new Scanner(text); Scanner inputScanner = new Scanner(System.in)) {
            String curLine;
            LexicalUnits units = new LexicalUnits();

            while (fileScanner.hasNextLine()) {
                curLine = fileScanner.nextLine();
                units.countUnits(curLine);
                System.out.println(curLine);
            }
            System.out.println();
            PrintInfo.printCounts(units);

            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            String input = inputScanner.next();
            System.out.println();

            Map<String, Readability> scoreMap = new HashMap<>();

            scoreMap.put("ARI", new ARIScore());
            scoreMap.put("FK", new FKScore());
            scoreMap.put("SMOG", new SMOGScore());
            scoreMap.put("CL", new CLScore());

            switch(input) {
                case "ARI":
                case "FK":
                case "SMOG":
                case "CL":
                    PrintInfo.printScore(input, scoreMap.get(input).compute(units));
                    System.out.println();
                    PrintInfo.printAge(scoreMap.get(input).getScore());
                    break;
                case "all":
                    PrintInfo.printScore("ARI", scoreMap.get("ARI").compute(units));
                    PrintInfo.printScore("FK", scoreMap.get("FK").compute(units));
                    PrintInfo.printScore("SMOG", scoreMap.get("SMOG").compute(units));
                    PrintInfo.printScore("CL", scoreMap.get("CL").compute(units));
                    System.out.println();
                    PrintInfo.printAge(scoreMap.get("ARI").getScore(), scoreMap.get("FK").getScore(),
                            scoreMap.get("SMOG").getScore(), scoreMap.get("CL").getScore());
                    break;
                default: System.out.println("Incorrect input.");
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
