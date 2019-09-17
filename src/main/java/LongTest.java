import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class LongTest {

    public static void main(String[] args) {
//        long sum = 0L;
        Long sum = 0L;

        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < Integer.MAX_VALUE; i++)
            sum += i;

        System.out.println(timer.elapsedTime());
        System.out.println(sum);
    }
}
