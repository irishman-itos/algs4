import java.io.*;
import java.util.*;

public class PointsAndLineSegments {
    private static Random random;
    private static Line[] lineLeftSorted;
    private static Line[] lineRightSorted;

    private static Line[] sort(Line[] lines, SortSite site) {
        sort(lines, 0, lines.length - 1, site);
        return lines.clone();
    }

    private static void exch(Line[] lines, int i, int j)
    {
        Line t = lines[i];
        lines[i] = lines[j];
        lines[j] = t;
    }

    private static int calculate(int value) {

        int lo = 0;
        int hi = lineLeftSorted.length - 1;
        int last1 = 0;
        int last2 = 0;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (value < lineLeftSorted[mid].left) {
                hi = mid - 1;
            } else if (value >= lineLeftSorted[mid].left) {
                lo = mid + 1;
                last1 = lo;
            }
        }

        lo = 0;
        hi = lineRightSorted.length - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (value <= lineRightSorted[mid].right) {
                hi = mid - 1;
            } else if (value > lineRightSorted[mid].right) {
                lo = mid + 1;
                last2 = lo;
            }
        }

        return last1 - last2;
    }

    public static void shuffle(Line[] lines) {
        random = new Random(System.currentTimeMillis());

        int n = lines.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);
            Line temp = lines[i];
            lines[i] = lines[r];
            lines[r] = temp;
        }
    }

    private static void insertion(Line[] lines, int lo, int hi, SortSite site) {
        for (int i = lo; i <= hi; i++)
        {
            if (site.equals(SortSite.leftSite))
                for(int j = i; j > 0 && lines[j].left < lines[j-1].left; j--)
                    exch(lines, j, j-1);
             else
                for(int j = i; j > 0 && lines[j].right < lines[j-1].right; j--)
                    exch(lines, j, j-1);
        }
    }

    private static void sort(Line[] lines, int lo, int hi, SortSite site) {
//        if (hi <= lo)
//            return;
        if (hi <= lo + 15) {
            insertion(lines, lo, hi, site);
            return;
        }

        int lt = lo, i = lo + 1, gt = hi;

        Integer v = lines[lo].left;
        if (site.equals(SortSite.rightSite))
            v =  lines[lo].right;

        while (i <= gt) {

            int cmp = lines[i].left.compareTo(v);
            if (site.equals(SortSite.rightSite))
                cmp = lines[i].right.compareTo(v);

            if      (cmp < 0) exch(lines, lt++, i++);
            else if (cmp > 0) exch(lines, i, gt--);
            else i++;
        }

        sort(lines, lo, lt - 1, site);
        sort(lines, gt + 1, hi, site);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("test-data/PointsAndLineSegments.txt"));

        String[] innerData = reader.readLine().split(" ");
        int lineCount = Integer.parseInt(innerData[0]);
        int pointCount = Integer.parseInt(innerData[1]);

        Line[] lineMap = new Line[lineCount];
        for (int i = 0; i < lineCount; i++) {
            innerData = reader.readLine().split(" ");
            lineMap[i] = new Line(Integer.parseInt(innerData[0]), Integer.parseInt(innerData[1]));
        }

        shuffle(lineMap);

        lineLeftSorted = sort(lineMap, SortSite.leftSite);
        lineRightSorted = sort(lineMap, SortSite.rightSite);

        innerData = reader.readLine().split(" ");
        int point;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pointCount; i++) {
            point = Integer.parseInt(innerData[i]);
            sb.append(calculate(point)).append(" ");
        }

        System.out.print(sb);
    }

    private static class Line {
        Integer left;
        Integer right;

        Line(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public String getName() {
            return left.toString() + right.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return left.equals(line.left) &&
                    right.equals(line.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }

    private enum SortSite {
        leftSite,
        rightSite
    }
}
