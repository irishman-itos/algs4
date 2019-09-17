import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStack {
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<>();

        StdOut.printf("Enter data\n");

        String[] string = StdIn.readString().split("");

//        List<String> openQuotes = Arrays.asList("{","[","(");
//        List<String> closeQuotes = Arrays.asList("}","]",")");

        Map<Integer, String> openQuotes = new HashMap<>();
        openQuotes.put(1, "{");
        openQuotes.put(2, "[");
        openQuotes.put(3, "(");

        Map<Integer, String> closeQuotes = new HashMap<>();
        closeQuotes.put(1, "}");
        closeQuotes.put(2, "]");
        closeQuotes.put(3, ")");

        for(String st : string)
        {
            if (closeQuotes.containsValue(st))
            {
                String openChar = stack.pop();
                int oV = getKeyByValue(openQuotes, openChar);
                int cV = getKeyByValue(closeQuotes, st);
                if (getKeyByValue(openQuotes, openChar) != getKeyByValue(closeQuotes, st))
                {
                    System.exit(0);
                }
            } else {
                stack.push(st);
            }
        }
        if (!stack.isEmpty())
            System.exit(0);
        System.exit(1);
    }

    private static Integer getKeyByValue(Map<Integer, String> map, String value)
    {
        for (Map.Entry<Integer, String> item : map.entrySet())
        {
            if(item.getValue().equals(value))
                return item.getKey();
        }

        return 0;
    }
}
