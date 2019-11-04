import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class CounterSort {
    private static int[] list;
    private static int[] resultList;
    private static Map<Integer, Integer> counters = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arraySize = Integer.parseInt(reader.readLine());
        list = new int[arraySize];
        resultList = new int[arraySize];

        String[] arrayString = reader.readLine().split(" ");
        for (int i = 0; i < arraySize; i++) {
            list[i] = Integer.parseInt(arrayString[i]);

            counters.putIfAbsent(list[i], 0);

            int curr = counters.get(list[i]);
            counters.put(list[i], ++curr);
        }

        counters = counters.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int prev = 0;
        for (Map.Entry<Integer, Integer> entry: counters.entrySet()) {
            entry.setValue(entry.getValue() + prev);
            prev = entry.getValue();
        }

        for (int i = arraySize - 1; i >= 0; i--) {
            resultList[counters.get(list[i]) - 1] = list[i];
            counters.put(list[i], counters.get(list[i]) - 1);
        }

        for (int i = 0; i < arraySize; i++) {
            System.out.print(resultList[i] + " ");
        }
    }
}
