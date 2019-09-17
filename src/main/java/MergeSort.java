public class MergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] list) {
        aux = new Comparable[list.length];
        sort(list, 0, aux.length - 1);
    }

    public static void sort(Comparable[] list, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;

        sort(list, lo, mid);
        sort(list, mid + 1, hi);

        merge(list, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k ++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (SpecialSortUtil.less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];

        }
    }
}
