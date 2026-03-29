import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Occurrences {

    public static void main(String[] args) {
        // String filePath = "/Users/rakesh/Desktop/Extract/nevada.txt";
        String filePath = "/Users/kalaiyarasan/Desktop/TestExtract/extractfile.txt";
        String pattern = "(?<!@)ESPNMQA-\\d+";
        Pattern r = Pattern.compile(pattern);

        Map<String, Integer> occurrences = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher m = r.matcher(line);
                while (m.find()) {
                    String match = m.group();
                    occurrences.put(match, occurrences.getOrDefault(match, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ESPNMQA Value\tOccurrences");
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("Total unique values: " + occurrences.size());
    }
}
