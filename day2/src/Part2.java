import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.FileReader;


public class Part2 {
    public static void main(String[] args) {
    
        
        int powersSum = 0;

        Pattern gamePattern = Pattern.compile("Game (\\d+): (.*)");
        Pattern roundPattern = Pattern.compile("(\\d+) (red;?|green;?|blue;?)");

        try (BufferedReader reader = new BufferedReader(new FileReader("input2.txt"))) {
            
            for (String line; (line = reader.readLine()) != null;) {
                
                int redCount = 0, greenCount = 0, blueCount = 0;
                int power = 0;
                int highestRedCount = 0, highestGreenCount = 0, highestBlueCount = 0;
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
                            if (redCount > highestRedCount) {
                                highestRedCount = redCount;
                            }
                            
                        } else if (color.equals("green")) {
                            greenCount += Integer.parseInt(number);
                            if (greenCount > highestGreenCount) {
                                highestGreenCount = greenCount;
                            }
                            
                        } else if (color.equals("blue")) {
                            blueCount += Integer.parseInt(number);
                            if (blueCount > highestBlueCount) {
                                highestBlueCount = blueCount;
                            }
                           
                        }
                        else if (color.equals("red;")) {
                            redCount += Integer.parseInt(number);
                            if (redCount > highestRedCount) {
                                highestRedCount = redCount;
                            }
                            System.out.println("Round Counts: " + " R:" + redCount + " G:" + greenCount + " B:" + blueCount);
                            
                            redCount = 0;
                            greenCount = 0;
                            blueCount = 0;
                        
                        }
                        else if (color.equals("green;")) {
                            greenCount += Integer.parseInt(number);
                            if (greenCount > highestGreenCount) {
                                highestGreenCount = greenCount;
                            }
                            System.out.println("Round Counts: " +  " R:" + redCount + " G:" + greenCount + " B:" + blueCount);
                         
                            redCount = 0;
                            greenCount = 0;
                            blueCount = 0;
                        
                        }
                        else if (color.equals("blue;")) {
                            blueCount += Integer.parseInt(number);
                            if (blueCount > highestBlueCount) {
                                highestBlueCount = blueCount;
                            }
                            System.out.println("Round Counts: " + " R:" + redCount + " G:" + greenCount + " B:" + blueCount);
                          
                            redCount = 0;
                            greenCount = 0;
                            blueCount = 0;
                        
                        } 
                    }
                    System.out.println("Highest Counts: " + " R:" + highestRedCount + " G:" + highestGreenCount + " B:" + highestBlueCount);
                    power = highestRedCount * highestGreenCount * highestBlueCount;
                    System.out.println("Power: " + power);
                    powersSum += power;
                    System.out.println("Powers Sum: " + powersSum);
                }
            }
            System.out.println(powersSum);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}