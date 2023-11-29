package tr.com.d3kod.y_2015.day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day03 {
    public static void run() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("./resources/15_day03.txt"));
            String line = reader.readLine();
            step1(line);
            step2(line);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void step2(String directions) {
        List<Point> points = new ArrayList<>();
        Point sPoint = new Point(0, 0);
        Point rPoint = new Point(0, 0);
        points.add(sPoint);
        for (int i = 0; i < directions.length(); i++) {
            char c = directions.charAt(i);
            Point newPoint;
            if (i % 2 == 0) {
                newPoint = move(c, sPoint);
                sPoint = newPoint;
            } else {
                newPoint = move(c, rPoint);
                rPoint = newPoint;
            }
            if (!points.contains(newPoint)) {
                points.add(newPoint);
            }
        }
        System.out.println("House count with robot:::: " + points.size());
    }

    private static Point move(char c, Point point) {
        Point sonuc;
        if (c == '^') {
            sonuc = point.north();
        } else if (c == 'v') {
            sonuc = point.south();
        } else if (c == '<') {
            sonuc = point.west();
        } else {
            sonuc = point.east();
        }
        return sonuc;
    }

    private static void step1(String directions) {
        List<Point> points = new ArrayList<>();
        Point lastPoint = new Point(0, 0);
        points.add(lastPoint);
        for (int i = 0; i < directions.length(); i++) {
            char c = directions.charAt(i);
            lastPoint = move(c, lastPoint);
            if (!points.contains(lastPoint)) {
                points.add(lastPoint);
            }
        }
        System.out.println("House count:::: " + points.size());
    }
}

class Point {

    private int x;
    private int y;

    public Point north() {
        return new Point(x, y + 1);
    }

    public Point south() {
        return new Point(x, y - 1);
    }

    public Point east() {
        return new Point(x + 1, y);
    }

    public Point west() {
        return new Point(x - 1, y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}
