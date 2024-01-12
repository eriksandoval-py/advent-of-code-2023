import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.HashMap;

public class Part2 {
    public static void main(String[] args) throws Exception {
        
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "o1e");
        map.put("two", "t2o");
        map.put("three", "t3e");
        map.put("four", "f4r");
        map.put("five", "f5e");
        map.put("six", "s6x");
        map.put("seven", "s7n");
        map.put("eight", "e8t");
        map.put("nine", "n9e");

        try (BufferedReader reader = new BufferedReader(new FileReader("input1.txt"))) {
            long sum = 0;

            String regex = "(\\d)";
            Pattern pattern = Pattern.compile(regex);

            for (String line; (line = reader.readLine()) != null;) {
                line = replaceWordsWithDigit(line, map);
                java.util.regex.Matcher matcher = pattern.matcher(line);
                String firstDigit = null;
                String lastDigit = null;
                while (matcher.find()) {
                    if (firstDigit == null) {
                        firstDigit = matcher.group();
                    }
                    lastDigit = matcher.group();
                }
                if (firstDigit != null) {
                    String digit = firstDigit + lastDigit;
                    sum += Long.parseLong(digit);
                }
            }
            System.out.println(sum);
        }
    }
    
    
    static String replaceWordsWithDigit(String line, HashMap<String, String> map) {
        for (String word : map.keySet()) {
            if (line.contains(word)) {
                line = line.replaceAll(word, map.get(word));
            }
        }
        return line;
    }
}
