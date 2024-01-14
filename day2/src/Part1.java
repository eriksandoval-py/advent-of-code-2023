import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.FileReader;


public class Part1 {
    public static void main(String[] args) {
    
        int redLimit = 12, greenLimit = 13, blueLimit = 14;

        int sum = 0;

        Pattern gamePattern = Pattern.compile("Game (\\d+): (.*)");
        Pattern roundPattern = Pattern.compile("(\\d+) (red;?|green;?|blue;?)");

        try (BufferedReader reader = new BufferedReader(new FileReader("input2.txt"))) {
            
            for (String line; (line = reader.readLine()) != null;) {
                boolean validGame = true;
                int redCount = 0, greenCount = 0, blueCount = 0;
                Matcher gameMatcher = gamePattern.matcher(line);

                if (gameMatcher.matches()) {

                    int gameID = Integer.parseInt(gameMatcher.group(1));
                    System.out.println("Game " + gameID);
                    String roundString = gameMatcher.group(2);
                    System.out.println(roundString);
                    Matcher roundMatcher = roundPattern.matcher(roundString);
                    
                    while (roundMatcher.find()) {
                        String color = roundMatcher.group(2);
                        System.out.println(color);
                        String number = roundMatcher.group(1);
                        System.out.println(number);
                        if (color.equals("red")) {
                            redCount += Integer.parseInt(number);
                            if (redCount > redLimit || greenCount > greenLimit || blueCount > blueLimit) {
                                validGame = false;
                                break;
                            }
                        } else if (color.equals("green")) {
                            greenCount += Integer.parseInt(number);
                            if (redCount > redLimit || greenCount > greenLimit || blueCount > blueLimit) {
                                validGame = false;
                                break;
                            }
                        } else if (color.equals("blue")) {
                            blueCount += Integer.parseInt(number);
                            if (redCount > redLimit || greenCount > greenLimit || blueCount > blueLimit) {
                                validGame = false;
                                break;
                            }
                        }
                        else if (color.equals("red;")) {
                            redCount += Integer.parseInt(number);
                            System.out.println("Round Counts: " + " R:" + redCount + " G:" + greenCount + " B:" + blueCount);
                            if (redCount > redLimit || greenCount > greenLimit || blueCount > blueLimit) {
                                validGame = false;
                                break;
                            }
                            redCount = 0;
                            greenCount = 0;
                            blueCount = 0;
                        
                        }
                        else if (color.equals("green;")) {
                            greenCount += Integer.parseInt(number);
                            System.out.println("Round Counts: " +  " R:" + redCount + " G:" + greenCount + " B:" + blueCount);
                            if (redCount > redLimit || greenCount > greenLimit || blueCount > blueLimit) {
                                validGame = false;
                                break;
                            }
                            redCount = 0;
                            greenCount = 0;
                            blueCount = 0;
                        
                        }
                        else if (color.equals("blue;")) {
                            blueCount += Integer.parseInt(number);
                            System.out.println("Round Counts: " + " R:" + redCount + " G:" + greenCount + " B:" + blueCount);
                            if (redCount > redLimit || greenCount > greenLimit || blueCount > blueLimit) {
                                validGame = false;
                                break;
                            }
                            redCount = 0;
                            greenCount = 0;
                            blueCount = 0;
                        
                        } 
                    }
                    if (validGame) {
                        System.out.println("Valid game: " + gameID);
                        sum += gameID;
                        System.out.println("Sum: " + sum + "\n\n");
                    } 
                }
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}