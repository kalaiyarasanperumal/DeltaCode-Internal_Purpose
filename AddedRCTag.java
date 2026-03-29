import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddedRCTag {
    public static void main(String[] args) {
        String filePath = "/Users/kalaiyarasan/Desktop/TestExtract/extractfile.txt";
        // Regex to capture ESPNMQA IDs
//        String regex = "ESPNMQA-\\d{3}";
        String regex = "ESPNMQA-\\d{3,4}";
        Pattern pattern = Pattern.compile(regex);
        LinkedHashSet<String> uniqueValues = new LinkedHashSet<>();

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

        // Build GROUP string
        StringBuilder groupBuilder = new StringBuilder("GROUP = '");
        int count = 0;
        int size = uniqueValues.size();

        for (String value : uniqueValues) {
            count++;
//            groupBuilder.append("@").append(value).append(" and @RC-Android");
//            groupBuilder.append("@").append(value).append(" and @RC-Android-Tablet");
//            groupBuilder.append("@").append(value).append(" and @RC-iOS");
//            groupBuilder.append("@").append(value).append(" and @RC-iOS-iPad");


//              groupBuilder.append("@").append(value).append(" and @androidApp");
//            groupBuilder.append("@").append(value).append(" and @android-tablet");
//            groupBuilder.append("@").append(value).append(" and @iosApp");
            groupBuilder.append("@").append(value).append(" and @iO/*/**/*/S-iPad");



            if (count < size) {
                groupBuilder.append(" or \n");
            }
        }
        groupBuilder.append("'");

        // Print final GROUP
        System.out.println(groupBuilder.toString());
        System.out.println("\nTotal unique values: " + uniqueValues.size());
    }
}

