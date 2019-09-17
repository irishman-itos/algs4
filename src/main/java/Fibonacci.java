import org.omg.CORBA.INTERNAL;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {

//    Map<Integer, BigInteger> cache = new HashMap<>();
    List<BigInteger> cache = new ArrayList<>();
    private static final int MOD = (int) (1e9+7);
    {
        cache.add(BigInteger.ZERO);
        cache.add(BigInteger.ONE);
    }
    private int fibonacci(int n)
    {
//        if (cache.containsKey(i))
//            return cache.get(i);
//        else {
//            BigInteger res = fibonacci(i - 1).add(fibonacci(i - 2));
//            cache.put(i, res);
//            return res;
//        }
//        for(int i = cache.size(); i <= n; i++)
//        {
//            BigInteger res = cache.get(i - 1).add(cache.get(i - 2));
//            cache.add(res);
//        }
//
//        return cache.get(n);

        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++)
        {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }

        return a;
    }

    private void run(int i)
    {
        System.out.println("num : " + i + " = " + fibonacci(i));
    }

    public static void main(String[] args)
    {
//        for(int i =0; i < 1001; i++) {
            long startTime = System.currentTimeMillis();
            new Fibonacci().run(100000);
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime + "ms");
//        }
    }
}
