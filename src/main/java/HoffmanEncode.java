import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoffmanEncode {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        List<NodeHoffman> nodes = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> library = new HashMap<>();
//        String string = "asas";
//        String string = "abacabad";
//        String string = "beep boop beer!";

        for (char ch: string.toCharArray()) {
            if (!map.containsKey(Character.toString(ch)))
                map.put(Character.toString(ch), 0);

            map.put(Character.toString(ch), map.get(Character.toString(ch)) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet())
            nodes.add(new NodeHoffman(entry.getKey(), entry.getValue(), null, null));

        while (nodes.size() > 1) {
            NodeHoffman min01 = cutMinNode(nodes);
            NodeHoffman min02 = cutMinNode(nodes);

            NodeHoffman newNode = new NodeHoffman(
                    min01.name + "+" + min02.name,
                    min01.value + min02.value,
                    min01,
                    min02);

            nodes.add(newNode);
        }

        System.out.println(getCode(nodes.get(0), "", library));

        // print result
        int sum = 0;
        String codedString = "";

        if (map.size() == 1) {
            codedString = "";
            System.out.println("1 " + string.length());
            System.out.println(nodes.get(0).name + ": 0" );

            for (char ch: string.toCharArray())
                codedString += "0";

        } else {
            for (char ch: string.toCharArray()) {
                codedString += library.get(Character.toString(ch));
                sum += library.get(Character.toString(ch)).length();
            }

            System.out.println(library.size() + " " + sum);

            for (Map.Entry<String, String> entry : library.entrySet())
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.print(codedString);
    }

    public static String getCode(NodeHoffman node, String codeSymbol, Map<String, String> library) {

        if (null != node.left)
            getCode(node.left, codeSymbol + "0", library);

        if (null != node.right)
            getCode(node.right, codeSymbol + "1", library);

        if (!node.name.contains("+"))
            library.put(node.name, codeSymbol);

        return "";
    }

    public static NodeHoffman cutMinNode(List<NodeHoffman> nodes) {
        NodeHoffman minNode = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++)
            minNode = less(minNode, nodes.get(i));

        nodes.remove(minNode);

        return minNode;
    }

    public static NodeHoffman less(NodeHoffman min, NodeHoffman node) {
        if (min.value > node.value)
            return node;

        return min;
    }

    public static class NodeHoffman {
        NodeHoffman left;
        NodeHoffman right;
        String name;
        int value;

        public NodeHoffman(String name, int value, NodeHoffman left, NodeHoffman right) {
            this.name  = name;
            this.value = value;
            this.left  = left;
            this.right = right;
        }
    }
}
