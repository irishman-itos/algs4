import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.concurrent.TimeUnit;

public class InsertionSortDouble {

    public static void main(String[] args) throws InterruptedException {

        StdDraw.setPenRadius(1);
        StdDraw.setPenColor(135,206,250);

        int N = 20;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();

        sort(a);
    }

    public static void sort(Comparable[] list)
//            throws InterruptedException
    {
        int N = list.length;
        int j = 1;
//        int min = 0;
        for (int i = 1; i < N; i++)
        {
//            draw(list, N, j);
            for(j = i; j > 0 && less(list[j], list[j-1]); j--)
            {
                exch(list, j, j-1);
            }
        }
    }

    public static void sort(Comparable[] list, int start, int end)
    {
        for (int i = start + 1; i < end + 1; i++)
        {
            for(int j = i; j > start && less(list[j], list[j-1]); j--)
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

    private static void draw(Comparable[] list, int N, int j) throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(500);
        StdDraw.clear();

        double k = 2;
        for (int i = 0; i < N; i++)
        {
            double x = 1.0 * i / N / k;
            double y = Double.parseDouble(list[i].toString()) / 2 / k;
            double rw = 0.5 / N  / k;
            double rh = Double.parseDouble(list[i].toString()) / 2  / k;

            if (i == j)
                StdDraw.setPenColor(0,0,0);
            else
                StdDraw.setPenColor(135,206,250);

            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
