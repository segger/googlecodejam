package se.johannalynn.google.codejam.y2021.qual.mediansort;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * src/main/java$ ln -sf se/johannalynn/google/codejam/y2021/qual/mediansort/interactive_runner.py interactive_runner.py
 * src/main/java$ ln -sf se/johannalynn/google/codejam/y2021/qual/mediansort/local_testing_tool.py local_testing_tool.py
 * src/main/java$ javac se/johannalynn/google/codejam/y2021/qual/mediansort/Solution.java
 *
 * src/main/java$ python interactive_runner.py python3 local_testing_tool.py 0 -- java se.johannalynn.google.codejam.y2021.qual.mediansort.Solution
 */

public class Solution {

    private static boolean debug = true;

    public static void main(String[] args) {
        run(args);
    }

    public static void run(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = in.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        for (int i = 0; i < T; i++) {
            List<Integer> nbrsToGuess = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());

            String guess = "1 2 3";
            System.out.println(guess);
            int response = Integer.parseInt(in.nextLine());
            Node root = new Node(response);
            NodeTree tree = new NodeTree(root);
            int idx = nbrsToGuess.indexOf(response);
            int medianNbr = response;
            nbrsToGuess.remove(idx);

            /*
            1. 1 (2) 3
            2. 2 (3) 4 -> add 3 as right
            3. 3 (4) 5 -> add 4 as right

            1. 1 2 (3)
            2. (3) 2 4 -> 1, 4 on the same side
            3. 1 3 (4) -> add 4 as left
             */

            int x = 0;
            boolean guessing = true;
            while (guessing) {
                int alreadyCompared = nbrsToGuess.get(0);
                int nextNbr = nbrsToGuess.get(idx);
                String nextGuess = "" + alreadyCompared + " " + nextNbr + " " + medianNbr;
                System.out.println(nextGuess);

                response = Integer.parseInt(in.nextLine());
                if (response == -1) {
                    System.exit(1);
                }
                idx = nbrsToGuess.indexOf(response);
                medianNbr = response;
                nbrsToGuess.remove(idx);

                if (nbrsToGuess.isEmpty() || ++x > 3) {
                    guessing = false;
                }
            }

            String sortedList = tree.printTree();
            System.out.println(sortedList);

            response = Integer.parseInt(in.nextLine());
            if (response == -1) {
                System.err.println("T: " + T + ", N: " + N + ", Q: " + Q);
                System.err.println("i: " + i);
                System.exit(1);
            }
        }
    }

    private static String sortedList(int N) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            buffer.append("" + i + " ");
        }
        return buffer.toString();
    }

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static class NodeTree {
        Node root;

        NodeTree(Node root) {
            this.root = root;
        }

        String printTree() {
            return print(root);
        }

        String print(Node node) {
            StringBuffer buffer = new StringBuffer();
            if (node != null) {
                String left = print(node.left);
                buffer.append(left + " ");
                buffer.append(node.key + " ");
                String right = print(node.right);
                buffer.append(right + " ");
            }
            return buffer.toString();
        }
    }
}
