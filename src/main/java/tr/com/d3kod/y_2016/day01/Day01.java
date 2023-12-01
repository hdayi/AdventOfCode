package tr.com.d3kod.y_2016.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {

  protected static List<Point> points = new ArrayList<>();

  public static void run() {

    BufferedReader reader;
    points.add(new Point(0, 0));

    try {
      reader = new BufferedReader(new FileReader("./resources/16_day01.txt"));
      String line = reader.readLine();

      String[] arr = line.split(",");
      Point p = new Point();

      for (int i = 0; i < arr.length; i++) {
        p.move(arr[i].replaceAll(" ", ""));
      }

      System.out.println(p.x + p.y);
      System.out.println(p);
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // System.out.println(points);
    for (Point p : points) {
      if (Collections.frequency(points, p) == 2) {
        System.out.println("oleeee");
        System.out.println(p);
      }
    }
  }

}

enum Direction {
  N, W, S, E
}

class Point {
  int x;
  int y;
  Direction direction;

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
    Point other = (Point) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  public Point() {
    x = 0;
    y = 0;
    direction = Direction.N;
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }

  protected void move(String command) {
    if (command.charAt(0) == 'L') {
      switch (this.direction) {
        case N:
          direction = Direction.W;
          break;

        case W:
          direction = Direction.S;
          break;
        case S:
          direction = Direction.E;
          break;
        case E:
          direction = Direction.N;
          break;
      }
      command = command.replace("L", "");
    } else {
      switch (this.direction) {
        case N:
          direction = Direction.E;
          break;

        case W:
          direction = Direction.N;
          break;
        case S:
          direction = Direction.W;
          break;
        case E:
          direction = Direction.S;
          break;
      }
      command = command.replace("R", "");
    }
    int step = Integer.parseInt(command);
    for (int i = 1; i <= step; i++) {
      switch (direction) {
        case N:
          y = y + 1;
          break;
        case S:
          y = y - 1;
          break;
        case E:
          x = x + 1;
          break;
        case W:
          x = x - 1;
          break;
      }
      Day01.points.add(new Point(this.x, this.y));
    }

  }
}
