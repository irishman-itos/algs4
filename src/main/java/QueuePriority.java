import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QueuePriority {
    static List<Integer> operations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        int operationCount = Integer.parseInt(string);


        for (int i = 0; i < operationCount; i++) {
            String[] inputStrings = reader.readLine().split(" ");

            if ("Insert".equals(inputStrings[0]))
            {
                int num = Integer.parseInt(inputStrings[1]);
                operations.add(num);

//                siftDown(operations.size() - 1);
                siftDown(0);
//                Collections.sort(operations, Collections.reverseOrder());
            } else {
                int max = operations.get(0);
                operations.remove(0);
                siftDown(0);

                System.out.println(max);
            }

        }

        System.out.println("");
    }

    public static void siftDown(int i) {
        while (2 * i + 1 < operations.size())
        {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int j = left;
            if (right < operations.size() && operations.get(right) < operations.get(left))
                j = right;
            if (operations.get(i) >= operations.get(j))
                break;

            i = j;
        }
    }

}
