public class MergeBUSort {
    private static Comparable[] aux;
    private static int comparing;
    private static int listCalls;

    public static void sort(Comparable[] list) {
        int N = list.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N-sz; lo += sz + sz)
                merge(list, lo, lo+sz-1, Math.min(lo + sz + sz - 1, N - 1));
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k ++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            comparing++;
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

    public static void main(String[] args) {
        int N = 1000;
        Double[] list  = SpecialSortUtil.getRandomArray(N);

//        SpecialSortUtil.printList(list);

//        System.out.println(SpecialSortUtil.isSort(list));

        sort(list);

//        SpecialSortUtil.printList(list);

        System.out.println(SpecialSortUtil.isSort(list));
        System.out.println("comparing = " + comparing);
        System.out.println("listCalls = " + listCalls);
    }
}
