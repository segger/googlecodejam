package se.johannalynn.google.codejamio.y2021.irrefutableoutcome;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final boolean debug = true;

    /*
Case #1: I 8
Case #2: O 7
Case #3: O 1
Case #4: I 1
Case #5: O 6
     */

    public static void main(String[] args) {
        if (debug) {
            String data = "5\n" +
                    "IOIOOOII\n" +
                    "OIIIIO\n" +
                    "IO\n" +
                    "IOIOIOI\n" +
                    "IOIOIOOIO\n";
            InputStream stdin = System.in;
            try {
                System.setIn(new ByteArrayInputStream(data.getBytes()));
                run(args);
            } finally {
                System.setIn(stdin);
            }
        } else {
            run(args);
        }
    }

    public static void run(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String B = in.nextLine();
            System.out.println("Case #" + i + ": " + result(B));
        }
    }

    private static String result(String B) {
        StringBuilder buffer = new StringBuilder();
        // generate full tree needed?

        String result = "Something went wrong";
        List<String> currentBoards = new ArrayList<>();
        currentBoards.add(B);
        boolean izabella = true;
        boolean finished = false;
        while (!finished && currentBoards.size() > 0) {
            String turn = izabella ? "I" : "O";
            List<String> newBoards = new ArrayList<>();
            for (String board : currentBoards) {
                // System.out.println("currentBoard: " + board + ", turn: " + turn);
                if (board.isEmpty()) {
                    finished = true; // or add to map for compare boards?
                    String winner = izabella ? "O" : "I";
                    result = winner + " 1";
                } else {
                    if (board.startsWith(turn) || board.endsWith(turn)) {
                        if (board.startsWith(turn)) {
                            String newBoard = board.substring(1);
                            newBoards.add(newBoard);
                        }
                        if (board.endsWith(turn)) {
                            String newBoard = board.substring(0, board.length() - 1);
                            newBoards.add(newBoard);
                        }
                    } else {
                        // System.out.println("multiple winners?");
                        finished = true; // or add to map for compare boards?
                        String winner = izabella ? "O" : "I";
                        int points = 1 + board.length();
                        result = winner + " " + points;
                        // System.out.println(result);
                    }
                }
            }
            currentBoards = newBoards;
            izabella = !izabella;
        }

        buffer.append(result);
        return buffer.toString();
    }
}
