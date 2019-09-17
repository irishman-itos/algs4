import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestBag {
    public static void main(String[] args)
    {
        Bag<Double> bagDouble = new Bag<Double>();

        StdOut.printf("Enter data\n");

        while (!StdIn.isEmpty())
            bagDouble.add(StdIn.readDouble());

        int numCount = bagDouble.size();

        double sum = 0.0;

        for (double x: bagDouble) {
            sum += x;
        }

        StdOut.printf("Avg : %.2f\n", sum/numCount);
    }
}
