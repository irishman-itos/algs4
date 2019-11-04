import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.concurrent.TimeUnit;

public class BuildMaxHeapTest {
    private static int N = 10;
    private static Integer[] list = new Integer[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++)
            list[i] = StdRandom.uniform(1, 20);

        SpecialSortUtil.printList(list);

        build();

        SpecialSortUtil.printList(list);
    }

    private static void build() {
        int count = (int) Math.floor(N / 2.0);
        for(int i = count; i >= 0 ; i--) {
            siftDown(i);
        }
    }

    // sift down index of heap
    private static void siftDown(int index) {
        int left = 2 * index + 1;                 // set value of child
        int right = 2 * index + 2;
        if (right >= N)                       // if child1or2 index is OOB (out of bounds)
            right = index;                        //  makes values index so l.35 returns false
        if (left >= N)                        //  and 0 here serves as safety net
            left = 0;
        if (left == 0 && right == index)        // if left & right aren't valid indices
            return;                               // for recursive completeness
        // if any child is greater than parent
        if ((list[index] < list[left]) || (list[index] < list[right])) {
            // determine which child is greater, sift that way
            if ((list[left] - list[index]) > (list[right] - list[index])) {
                int element = list[index];       // since list is of ints
                list[index] = list[left];       // swap elements left
                list[left] = element;
                siftDown(left);                   // if move was made recurse, else its done.
            } else if ((list[left] - list[index]) <= (list[right] - list[index])){
                int element = list[index];       // since list is of ints
                list[index] = list[right];      // swap elements right
                list[right] = element;
                siftDown(right);                  // if move was made recurse, else its done.
            }
        }
    }

    // sift up in heap 
    private void siftUp(int index) {
        // if index is bigger than parent, then swap
        int parent = (index -1) / 2;       // set value of parent
        if (parent < 0)                    // if parent is negative, 0
            return;                          // for recursive completeness 
        if (list[index] > list[parent]) {
            int element = list[index];      // since list is of ints
            list[index] = list[parent];    // swap elements
            list[parent] = element;
            siftUp(parent);                  // if move was made, recurse. else its done.
        }
    }
}
