import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class TestDijkstraCalc {
    public static void main(String[] args) throws IOException {

        StdOut.printf("Enter data\n");

        String test = StdIn.readString();

        char[] chars = test.toCharArray();

        Stack<Double> numbers = new Stack<Double>();
        Stack<String> operations = new Stack<String>();
        String line = null;
        for(int i = 0; i < chars.length; i++)
        {
//            Integer num = (Integer) Character.getNumericValue(chars[i]);
//            if(chars[i] == '(')
//            {
//                continue;
//            }
//            if (num > 0)
//            {
//                numbers.push((Double) num);
//            } else if (chars[i] == ')') {
//                Integer num1 = numbers.pop();
//                Integer num2 = numbers.pop();
//                String operation = operations.pop();
//
//                if ("+".equals(operation))
//                    numbers.push(num1+num2);
//                if ("+".equals(operation))
//                    numbers.push(num1+num2);
//
//            } else if


        }

    }
}
