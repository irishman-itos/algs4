import java.util.Map;
import java.util.function.*;

public class GCM {

    private int gcm(int a, int b)
    {
        int res = 1;
        for(int i = 1; i <= Math.max(a,b); i++)
        {
            if (a % i == 0 && b % i == 0)
                res = i;
        }
        return res;
    }
    private int gcm1(int a, int b)
    {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) {
            return gcm1(a % b, b);
        } else {
            return gcm1(b % a, a);
        }
    }


    private void run(int a, int b)
    {
        System.out.println(gcm(a,b));
//        System.out.println(gcm1(a,b));
    }

    public static void main(String[] args)
    {
//        long startTime = System.currentTimeMillis();
//        new GCM().run(5122 * 2342, 5122 * 4211);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms");

//        Function<Integer, Integer> f = x -> x + 3;
//
//        BiFunction<Function<Integer, Integer>, Integer, Integer> g = (func, x) -> func.apply(x) * func.apply(x);
//
//        System.out.println(g.apply(f, 6));

    }
}
