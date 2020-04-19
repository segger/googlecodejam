package se.johannalynn.google.codejam.y2020.r1b.expogo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main2(String[] args) {
        String data = "5\n" +
                "0 1\n" +
                "2 3\n" +
                "-2 -3\n" +
                "3 0\n" +
                "-1 1\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.valueOf(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                String[] input = in.nextLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                System.out.println("Case #" + i + ": " + result(x, y));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String[] input = in.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            System.out.println("Case #" + i + ": " + result(x, y));
        }
    }

    static class Position {
        int level;
        int x;
        int y;
        String jump;
    }

    private static List<Position> generateLeafs(Position p) {
        List<Position> children = new ArrayList<>();

        Position north = new Position();
        north.x = p.x;
        north.y = p.y + (2*p.level);
        north.jump = p.jump + "N";
        north.level = p.level + 1;

        Position south = new Position();
        south.x = p.x;
        south.y = p.y - (2*p.level);
        south.jump = p.jump + "S";
        south.level = p.level + 1;

        Position east = new Position();
        east.x = p.x + (2*p.level);
        east.y = p.y;
        east.jump = p.jump + "E";
        east.level = p.level + 1;

        Position west = new Position();
        west.x = p.x - (2*p.level);
        west.y = p.y;
        west.jump = p.jump + "W";
        west.level = p.level + 1;

        children.add(north);
        children.add(south);
        children.add(east);
        children.add(west);

        return children;
    }

    private static Position checkPositions(List<Position> positions, int x, int y) {
        for(Position pos : positions) {
            if(pos.x == x && pos.y == y) {
                return pos;
            }
        }
        return null;
    }

    private static String result(int x, int y) {
        StringBuffer jumps = new StringBuffer();
        if (Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 1) {

            Position north = new Position();
            north.x = 0;
            north.y = 1;
            north.jump = "N";
            north.level = 1;

            Position south = new Position();
            south.x = 0;
            south.y = -1;
            south.jump = "S";
            south.level = 1;

            List<Position> positions = new ArrayList<>();
            positions.add(north);
            positions.add(south);

            Position pos = checkPositions(positions, x, y);
            if (pos != null) {
                return pos.jump;
            }

            int i = 0;
            while(i < 10000) {
                List<Position> leafs = new ArrayList<>();
                for (Position position : positions) {
                    leafs.addAll(generateLeafs(position));
                }

                Position leaf = checkPositions(leafs, x, y);
                if (leaf != null) {
                    return leaf.jump;
                }

                positions = leafs;
                i++;
            }

        } else if (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 0){
            Position east = new Position();
            east.x = 1;
            east.y = 0;
            east.jump = "E";
            east.level = 1;

            Position west = new Position();
            west.x = -1;
            west.y = 0;
            west.jump = "W";
            west.level = 1;

            List<Position> positions = new ArrayList<>();
            positions.add(east);
            positions.add(west);

            Position pos = checkPositions(positions, x, y);
            if (pos != null) {
                return pos.jump;
            }

            int i = 0;
            while(i < 10000) {
                List<Position> leafs = new ArrayList<>();
                for (Position position : positions) {
                    leafs.addAll(generateLeafs(position));
                }

                Position leaf = checkPositions(leafs, x, y);
                if (leaf != null) {
                    return leaf.jump;
                }

                positions = leafs;
                i++;
            }
        } else {
            jumps.append("IMPOSSIBLE");
        }
        return jumps.toString();
    }
}
