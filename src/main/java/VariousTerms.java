import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VariousTerms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String data = reader.readLine();
        int number = Integer.parseInt(data);

        List<Integer> result = new ArrayList<>();

        if (number == 1) {
            System.out.println(1);

            System.out.print(1);
        } else {
            int prev = 0;
            int current = 0;

            for (int i = 1; i <= number; i++) {
                current += i;
                if(current <= number) {
                    if (prev > 0)
                        result.add(prev);
                    prev = i;
                } else {
                    prev = prev +  (number - (current - i));
                    result.add(prev);

                    break;
                }
            }

            System.out.println(result.size());

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        }


    }
}
