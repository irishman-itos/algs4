public class LineZeroOneSort {

    public static void sort(Comparable[] list) {
        int j = list.length - 1;
        int i = 0;
        while (i <= j) {
            if (list[i].equals(1) && list[i].equals(list[j]))
            {
                j--;
                continue;
            } else if (list[i].equals(0) && list[i].equals(list[j]))
            {
                i++;
                continue;
            } else if (SpecialSortUtil.less(list[j], list[i])) {
                SpecialSortUtil.exch(list, i, j);
            }
            j--;
            i++;

        }
    }

    public static void main(String[] args) {
        int N = 1000;
        Integer[] list  = SpecialSortUtil.getZeroOneArray(N);

//        SpecialSortUtil.printList(list);
        System.out.println(SpecialSortUtil.isSort(list));

        sort(list);
//        SpecialSortUtil.printList(list);

        System.out.println(SpecialSortUtil.isSort(list));
    }
}
