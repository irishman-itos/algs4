
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueuePriorityArrayList {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        int operationCount = Integer.parseInt(string);
//        List<Integer> operations = new ArrayList<>();
        Integer[] operations = new Integer[operationCount];

        int index = 0;

        for (int i = 0; i < operationCount; i++) {
            String[] inputStrings = reader.readLine().split(" ");

            if ("Insert".equals(inputStrings[0]))
            {
                int num = Integer.parseInt(inputStrings[1]);
//                operations.add(num);
                operations[index] = num;
                index++;

//                Collections.sort(operations, Collections.reverseOrder());
                sort(operations);
            } else {
                int max = operations[--index];
                operations[index] = null;

                System.out.println(max);
            }

        }
    }

    public static void sort(Comparable[] list) {
        sort(list, 0, list.length - 1);
    }

    public static void sort(Comparable[] list, int lo, int hi) {

        if (hi <= lo)
            return;

        int j = partition(list, lo, hi);

        sort(list, lo, j - 1);
        sort(list, j + 1, hi);

    }

    public static int partition(Comparable[] list, int lo, int hi) {
        int i = lo, j = hi + 1;

        Comparable v = list[lo];

        while (true) {
            while (less(list[++i], v)) if (i == hi) break;
            while (less(v, list[--j])) if (j == lo) break;

            if(i >= j)
                break;

            exch(list, i, j);
        }

        exch(list, lo, j);
        return j;
    }

    public static Boolean less(Comparable v, Comparable w)
    {
        if (v == null)
            return false;
        if (w == null)
            return true;

        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] list, int i, int j)
    {
        Comparable t = list[i];
        list[i] = list[j];
        list[j] = t;
    }
}
