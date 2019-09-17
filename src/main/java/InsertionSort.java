import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionSort {

    public static void main(String[] args) {

        StdDraw.setPenRadius(1);
        StdDraw.setPenColor(135,206,250);

        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
//
//        Arrays.sort(a);
//
//        for (int i = 0; i < N; i++)
//        {
//            double x = 1.0 * i / N;
//            double y = a[i] / 2;
//            double rw = 0.5 / N;
//            double rh = a[i] / 2;
//
//            StdDraw.filledRectangle(x, y, rw, rh);
//        }

        String[] stringList = StdIn.readAllStrings();

        sort(stringList);

        for (String item: stringList)
        {
            System.out.print(item + " ");
        }
    }

    private static void sort(Comparable[] list)
    {
        int N = list.length;

        for (int i = 1; i < N; i++)
        {
            draw(list, N);
            for(int j = i; j > 0 && less(list[j], list[j-1]); j--)
                exch(list, j, j-1);
        }

    }

    private static Boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] list, int i, int j)
    {
        Comparable t = list[i];
        list[i] = list[j];
        list[j] = t;
    }

    private static void draw(Comparable[] list, int N)
    {
        StdDraw.setPenColor(135,206,250);
        double k = 10;
        for (int i = 0; i < N; i++)
        {
            double x = 1.0 * i / N / k;
            double y = Double.parseDouble(list[i].toString()) / 2 / k;
            double rw = 0.5 / N  / k;
            double rh = Double.parseDouble(list[i].toString()) / 2  / k;

            if (i == N -1)
                StdDraw.setPenColor(0,0,0);

            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
