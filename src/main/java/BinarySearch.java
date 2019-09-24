import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {

    private static int[] list;
    private static int searchKey;

    private static int indexOf(int lo, int hi) {
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
//            int mid = lo + (hi - lo) / 2;

            if (list[mid] == searchKey)
                return mid;

            if (list[mid] > searchKey)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return -2;
    }

    public static int search(int lo, int hi) {

        if (hi <= lo)
            return -2;

        int mid = (hi + lo) / 2;

        if (list[mid] == searchKey)
            return mid;
        if (list[mid] < searchKey)
            return search(mid + 1, hi);
        else
            return search(lo, mid - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] innerData = reader.readLine().split(" ");
        int arraySize = Integer.parseInt(innerData[0]);
        list = new int[arraySize];
        for (int i = 1; i <= arraySize; i++)
            list[i-1] = Integer.parseInt(innerData[i]);

        Arrays.sort(list);

        innerData = reader.readLine().split(" ");
        int operationCount = Integer.parseInt(innerData[0]);

        for (int i = 1; i <= operationCount; i++)
        {
            searchKey = Integer.parseInt(innerData[i]);
            System.out.print((indexOf(0, list.length - 1) + 1) + " ");
        }
    }
}
