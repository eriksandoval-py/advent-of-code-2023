import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input1.txt"))) {
            long sum = 0;

            String regex = "(\\d)";
            Pattern pattern = Pattern.compile(regex);

            for (String line; (line = reader.readLine()) != null;) {
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
}