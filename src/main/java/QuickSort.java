import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    public static void sort(Comparable[] list) {
        StdRandom.shuffle(list);

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
            while (SpecialSortUtil.less(list[++i], v)) if (i == hi) break;
            while (SpecialSortUtil.less(v, list[--j])) if (j == lo) break;

            if(i >= j)
                break;

            SpecialSortUtil.exch(list, i, j);
        }

//        Boolean.valueOf(true);

        SpecialSortUtil.exch(list, lo, j);
        return j;
    }

    public static void main(String[] args) {
        int N = 10;
//        Double[] list  = SpecialSortUtil.getRandomArray(N);
        Integer[] list  = SpecialSortUtil.getZeroOneArray(N);

        sort(list);

        System.out.println(SpecialSortUtil.isSort(list));
    }
}
