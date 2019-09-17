import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoffmanDecode {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStrings = reader.readLine().split(" ");
        Map<String, String> library = new HashMap<>();
        String codedString = "";

        int codeStringLength = Integer.parseInt(inputStrings[1]);

        while (true) {
            String inputString = reader.readLine();

            if (inputString.contains(": ")) {
                inputStrings = inputString.split(": ");
                library.put(inputStrings[1], inputStrings[0]);

                continue;
            }

            codedString = inputString;
            break;
        }

        int end = 1;
        int start = 0;
        String substring = "";
        for (int i = 0; i < codeStringLength; i++) {
            substring = codedString.substring(start, end);

            if (library.get(substring) == null) {
                end++;
                continue;
            }
            start = end;
            end++;
            System.out.print(library.get(substring));
        }
    }
}
