package tr.com.d3kod.y_2016.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day01 {

  public static void run() {

    BufferedReader reader;

    try {
      reader = new BufferedReader(new FileReader("./resources/16_day01.txt"));
      String line = reader.readLine();

      System.out.println(line);

      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
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

  public Point(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

protected move(char yon, int step){
    
  }
}
