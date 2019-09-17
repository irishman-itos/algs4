import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class UFTest {
    private int[] id;
    private int[] sz;
    private int count;

    public UFTest(int N) throws IllegalArgumentException {
        if (N < 0)
            throw new IllegalArgumentException();
        count = N;
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public UFTest(int[] a)
    {
        id = a;
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    public int find(int p)
    {
        // Quick search
//        return id[p];

        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

//        for(int i =0; i < id.length; i++)
//            if(id[i] == pID) id[i] = qID;
//        id[pID] = qID;

        if (sz[pID] < sz[qID]) {
            id[pID] = qID;
            sz[qID] += sz[pID];
        } else {
            id[qID] = pID;
            sz[pID] += sz[qID];
        }

        count--;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        int N = StdIn.readInt();
        UFTest ufTest = new UFTest(N);

//        int[] a = new In(args[0]).readAllInts();
//        Arrays.sort(a);

        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (ufTest.connected(p, q)) continue;

            ufTest.union(p, q);

            StdOut.println(p + " " + q);
        }
        StdOut.println(ufTest.count() + " of components");
    }
}
