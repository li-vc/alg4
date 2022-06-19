package als1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 加权quickunion -算法1.5
 */
public class WeightedQuickUnionUF
{
    private int[] id; // parent link (site indexed)
    private int[] sz; // size of component for roots (site indexed)
    private int count; // number of components
    public int cost=0;
    private int total = 0;
    public WeightedQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }
    public int count()
    { return count; }
    public boolean connected(int p, int q)
    { return find(p) == find(q); }
    private int find(int p)
    { // Follow links to find a root.
        while (p != id[p]) {
            p = id[p];
            cost++;
        }
        return p;
    }
    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; cost++;}
        else { id[j] = i; sz[i] += sz[j]; cost++;}
        count--;
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightQuickPressUnionUF uf = new WeightQuickPressUnionUF(n);
        Stopwatch time = new Stopwatch();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);

            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.printf("%5.1f",time.elapsedTime());
    }
}