import edu.princeton.cs.algs4.StdRandom;

public class QuickSort3Way {

    public static void sort(Comparable[] list) {
        StdRandom.shuffle(list);

        sort(list, 0, list.length - 1);
    }

    public static void sort(Comparable[] list, int lo, int hi) {

        if (hi <= lo)
            return;

        int lt = lo, i = lo + 1, gt = hi;

        Comparable v = list[lo];

        while (i <= gt) {
            int cmp = list[i].compareTo(v);

            if (cmp < 0) SpecialSortUtil.exch(list, lt++, i++);
            else if (cmp > 0) SpecialSortUtil.exch(list, i, gt--);
            else i++;
        }

        sort(list, lo, lt - 1);
        sort(list, gt + 1, hi);

    }

    public static void main(String[] args) {
        int N = 10000;
        Double[] list  = SpecialSortUtil.getRandomArray(N);

        sort(list);

        System.out.println(SpecialSortUtil.isSort(list));
    }
}
