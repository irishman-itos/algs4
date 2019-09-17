import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.concurrent.TimeUnit;

public class ShellSort {

    public static void main(String[] args) throws InterruptedException {

        StdDraw.setPenRadius(1);
        StdDraw.setPenColor(135,206,250);

        int N = 10;
//        Double[] a = new Double[N];
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(1, 20);

        sort(a);
    }

    public static void sort(Comparable[] list)
//            throws InterruptedException
    {
        int N = list.length;
        int h = 1;

        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
//                 draw(list, N, i);
                for(int j = i; j >= h && less(list[j], list[j-h]); j -= h) {
                    exch(list, j, j-h);
                }
            }

            h /= 3;
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

        double k = 1;
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
