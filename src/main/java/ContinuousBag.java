import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ContinuousBag {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        int itemCount = Integer.parseInt(data[0]);
        int bagWeight = Integer.parseInt(data[1]);


        if (itemCount < 0 || bagWeight < 0)
            throw new IllegalArgumentException();

        Item[] items = new Item[itemCount];

        for(int i = 0; i < itemCount; i++)
        {
            String[] points = reader.readLine().split(" ");
            float price = Float.parseFloat(points[0]);
            int count = Integer.parseInt(points[1]);

            Item item = new Item(price, count);
            items[i] = item;
        }

        Arrays.sort(items, Collections.reverseOrder());

        double maxPrice = 0;
        for (int i = 0; i < items.length; i++)
        {
            if (bagWeight >= items[i].count) {
                bagWeight -= items[i].count;
                maxPrice += items[i].price;

                if(bagWeight <= 0)
                    break;
            } else {
                double onePeacePrice = items[i].price / items[i].count;
                for (int j = 0; j < items[i].count; j++)
                {
                    if(bagWeight <= 0)
                        break;

                    bagWeight--;
                    maxPrice += onePeacePrice;
                }
            }

        }


        System.out.printf("%.3f", maxPrice);
    }

    public static class Item implements Comparable<Item> {
        public float price;
        public int count;

        Item(float price, int count)
        {
            this.price = price;
            this.count = count;
        }

        @Override
        public int compareTo(Item o) {
            return (this.price / this.count < o.price / o.count) ? -1 : ((this.price / this.count == o.price / o.count) ? 0 : 1);
        }

        @Override
        public String toString() {
            return this.count + " " + this.price;
        }
    }
}
