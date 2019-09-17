import edu.princeton.cs.algs4.*;

public class SortCompare {
    public static double time(Object algorithm, Double[] list) {
        Stopwatch timer = new Stopwatch();

        if ("Insertion".equals(algorithm))
            Insertion.sort(list);
        else
//            InsertionSortDouble.sort(list);
        Selection.sort(list);
//            ShellSort.sort(list);


        return timer.elapsedTime();
    }

    public static double timeRandomInput(String arg, int N, int T) {
        double total = 0.0;

        Double[] list = new Double[N];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                list[j] = StdRandom.uniform();
            }

            total += time(arg, list);
        }

        return total;
    }

    public static void main(String[] args) {

        int T = 2;
        int N = 100000;

        double t1 = timeRandomInput("Insertion", N, T);
        double t2 = timeRandomInput("Selection", N, T);

        StdOut.println(t1);
        StdOut.println(t2);
        StdOut.printf("For %d random double numbers\n %s in ", N, "Insertion");
        StdOut.printf("%.1f quicker than  %s\n", t2/t1, "Selection");
    }
}
