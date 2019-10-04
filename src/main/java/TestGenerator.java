import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class TestGenerator {
    private static Random random;
    private static void PointsAndLineSegmentsSave() throws IOException {
        random = new Random(System.currentTimeMillis());

        int n = 15000;
        int m = 15000;

        FileWriter file = new FileWriter("test-data/PointsAndLineSegments.txt");

        file.write(n + " " + m + "\n");
        for(int i = 0; i < n; i++) {

            int leftPoint = random.nextInt(n);
            int rightPoint = leftPoint + random.nextInt(n - leftPoint);

            file.write(leftPoint + " " + rightPoint + "\n");
        }

        for(int i = 0; i < m; i++) {
            file.write(random.nextInt(m) + " ");
        }

        file.close();
    }

    public static void main(String[] args) throws IOException {
        PointsAndLineSegmentsSave();
    }
}
