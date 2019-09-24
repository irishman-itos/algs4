import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class SpecialSortUtil {


    public static Double[] getSortedArray(int N) {

        Double[] list = new Double[N];

        for (int j = 0; j < N; j++) {
            list[j] = StdRandom.uniform();
        }

        Arrays.sort(list);

        return list;
    }

    public static Double[] getSortedBackArray(int N) {

        Double[] list = new Double[N];

        for (int j = 0; j < N; j++) {
            list[j] = StdRandom.uniform();
        }

        Arrays.sort(list, Collections.reverseOrder());

        return list;
    }

    public static Integer[] getZeroOneArray(int N) {

        Integer[] list = new Integer[N];

        for (int j = 0; j < N; j++) {
            list[j] = StdRandom.uniform(2);
        }

        return list;
    }

    public static Double[] getRandomArray(int N) {

        Double[] list = new Double[N];

        for (int j = 0; j < N; j++) {
            list[j] = StdRandom.uniform();
        }


        return list;
    }

    public static Integer[] getRandomIntArray(int N) {

        Integer[] list = new Integer[N];

        for (int j = 0; j < N; j++) {
            list[j] = StdRandom.uniform(N);
        }


        return list;
    }

    public static Boolean less(Comparable v, Comparable w)
    {
        return null != v && v.compareTo(w) < 0;
    }

    public static Boolean isSort(Comparable[] list) {
        for (int i = 1; i < list.length; i++)
            if (less(list[i], list[i-1]))
                return false;
        return true;
    }


    public static void printList(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println("");
    }

    public static void exch(Comparable[] list, int i, int j)
    {
        Comparable t = list[i];
        list[i] = list[j];
        list[j] = t;
    }
}
