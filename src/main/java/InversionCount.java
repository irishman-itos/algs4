import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionCount {

    private static int[] list;
    private static int[] aux;
    private static long count;

    public static void calculateBy(int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;

        calculateBy(lo, mid);
        calculateBy(mid + 1, hi);

        merge(lo, mid, hi);
    }

    public static void merge(int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k ++) {
            aux[k] = list[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                list[k] = aux[j++];
            else if (j > hi)
                list[k] = aux[i++];
            else if (aux[i] > aux[j])
            {
                list[k] = aux[j++];
                count += mid - i + 1;
            }
            else {
                list[k] = aux[i++];
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arraySize = Integer.parseInt(reader.readLine());
        String[] innerData = reader.readLine().split(" ");

        list = new int[arraySize];
        for (int i = 0; i < arraySize; i++)
            list[i] = Integer.parseInt(innerData[i]);

        aux = new int[list.length];

        calculateBy(0, arraySize - 1);

        System.out.println(count);
    }
}
