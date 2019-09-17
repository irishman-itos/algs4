import edu.princeton.cs.algs4.*;

import java.awt.*;

public class SortCompareDouble {
    public static double time(String algorithm, Double[] list) {
        Stopwatch timer = new Stopwatch();

        switch (algorithm) {
            case "Insertion" :
                Insertion.sort(list);
                break;

            case "ShellSort" :
                ShellSort.sort(list);
                break;

            case "Selection" :
                Selection.sort(list);
                break;

            case "MergeSort" :
                MergeSort.sort(list);
                break;

            case "MergeSortPlus" :
                MergeSortPlus.sort(list);
                break;

            case "MergeBUSort" :
                MergeBUSort.sort(list);
                break;

            case "QuickSort" :
                QuickSort.sort(list);
                break;

            case "QuickSortM" :
                QuickSortM.sort(list);
                break;

            case "QuickSort3Way" :
                QuickSort3Way.sort(list);
                break;
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;

//        Double[] list  = SpecialSortUtil.getSortedArray(N);
//        Double[] list  = SpecialSortUtil.getSortedBackArray(N);
//        Integer[] list  = SpecialSortUtil.getZeroOneArray(N);
        Double[] list  = SpecialSortUtil.getRandomArray(N);

        total += time(alg, list);

//        StdOut.println(alg + " - " + SpecialSortUtil.isSort(list));

        return total;
    }

    public static void main(String[] args) {

        int tries = 15; // count of comparing
        int index = 2; // number of test step
        int N = 1000; // start list element
        int T = 2;

        String alg1 = "QuickSort3Way";
        String alg2 = "QuickSort";

//        drawSettings(N * tries);

        for (int i = 0; i < tries; i++) {
            double t1 = timeRandomInput(alg1, N, T);
            double t2 = timeRandomInput(alg2, N, T);

            StdOut.println("Step #" + i);
            StdOut.println("Count " + N);
            StdOut.println(alg1 + " - " + t1);
            StdOut.println(alg2 + " - " + t2);
            StdOut.println(alg2 + "/" + alg1 + " - " + t2/t1);

//            drawChart(N, t1);

            N *= index;
        }
    }

    private static void drawSettings(int N) {
        StdDraw.setXscale(0, N / 5000);
        StdDraw.setYscale(0, N * N / 5000);
        StdDraw.setPenRadius(.05);
        StdDraw.setPenColor(Color.CYAN);
    }

    private static void drawChart(int N, double time) {
        double yPoint =  time * 100000;
        StdDraw.point(N / 5000, yPoint);
    }
}
