import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// // non_espn_appium_user_74_android@mailinator.com

public class Testcase_List {
    public static void main(String[] args) {
        // String filePath = "/Users/rakesh/Desktop/Extract/alaska.txt";
        String filePath = "/Users/kalaiyarasan/Desktop/TestExtract/extractfile.txt";
        
        // Regular expression pattern to match 'ESPNMQA-XXXXX'
//        String regex = "ESPNMQA-\\d{3}";
        String regex = "ESPNMQA-\\d{3,4}";
        Pattern pattern = Pattern.compile(regex);
        HashSet<String> uniqueValues = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    uniqueValues.add(matcher.group());
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String value : uniqueValues) {
            System.out.println(value);
        }
        System.out.println("Total unique values: " + uniqueValues.size());
    }
}