import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CoveringSegmentsByPoints {
    static List<Integer> crossPoints = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String segmentsCountStr = reader.readLine();

        int segmentsCount = Integer.parseInt(segmentsCountStr);
        Segment[] segments = new Segment[segmentsCount];

        if (segmentsCount < 1)
            throw new IllegalArgumentException();

        for(int i = 0; i < segmentsCount; i++)
        {
            String[] points = reader.readLine().split(" ");
            int x = Integer.parseInt(points[0]);
            int y = Integer.parseInt(points[1]);

            Segment segment = new Segment(x, y);
            segments[i] = segment;
        }

        Arrays.sort(segments);

        for (int i = 0; i < segments.length; i++)
        {
            if (inRange(segments[i]))
                continue;

            if(!crossPoints.contains(segments[i].y))
                crossPoints.add(segments[i].y);
        }

        System.out.println(crossPoints.size());

        for (Integer point: crossPoints) {
            System.out.print(point + " ");
        }
    }

    public static boolean inRange(Segment segment)
    {
        for (int point : crossPoints)
            if (point >= segment.x && point <= segment.y)
                return true;

        return false;
    }

    public static class Segment implements Comparable<Segment> {
        public int x;
        public int y;

        Segment(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Segment o) {
//            return (this.x < o.x) ? -1 : ((this.x == o.x) ? 0 : 1);
            return (this.y < o.y) ? -1 : ((this.y == o.y) ? 0 : 1);
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}
