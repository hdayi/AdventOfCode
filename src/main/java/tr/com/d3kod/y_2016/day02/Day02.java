package tr.com.d3kod.y_2016.day02;

import java.util.ArrayList;
import java.util.List;

import tr.com.d3kod.util.ReadFile;

/**
 * Day02
 */
public class Day02 {

  private static List<String> input = new ArrayList<>();
  private static int[][] keypad = {
      { 1, 2, 3 },
      { 4, 5, 6 },
      { 7, 8, 9 }
  };
  public static String[][] newKeypad = {
      { null, null, "1", null, null },
      { null, "2", "3", "4", null },
      { "5", "6", "7", "8", "9" },
      { null, "A", "B", "C", null },
      { null, null, "D", null, null }
  };

  public static void run() {
    System.out.println("Hello 2012 Day02");
    input = ReadFile.readFile("16_day02.txt");
    solve();
  }

  private static void solve() {
    System.out.println(newKeypad[2][0]);
    String code = "";
    String newCode = "";
    for (String line : input) {
      Point p = new Point();
      NewPoint np = new NewPoint();
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        switch (c) {
          case 'U':
            p.up();
            np.up();
            break;
          case 'D':
            p.down();
            np.down();
            break;
          case 'L':
            p.left();
            np.left();
            break;
          case 'R':
            p.right();
            np.right();
            break;
        }
      }
      code += Integer.toString(
          keypad[p.getX()][p.getY()]);
      newCode += newKeypad[np.getX()][np.getY()];
    }
    System.out.println("2016 Day02 Step 1: " + code);
    System.out.println("2016 Day02 Step 2: " + newCode);
  }
}

class NewPoint {
  private int x;
  private int y;

  public void up() {
    if (x > 0 && Day02.newKeypad[x - 1][y] != null)
      x -= 1;
  }

  public void down() {
    if (x < 4 && Day02.newKeypad[x + 1][y] != null)
      x += 1;
  }

  public void right() {
    if (y < 4 && Day02.newKeypad[x][y + 1] != null)
      y += 1;
  }

  public void left() {
    if (y > 0 && Day02.newKeypad[x][y - 1] != null)
      y -= 1;
  }

  public NewPoint() {
    x = 2;
    y = 0;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}

class Point {
  private int x;
  private int y;

  public void up() {
    if (x > 0)
      x -= 1;
  }

  public void down() {
    if (x < 2)
      x += 1;
  }

  public void right() {
    if (y < 2)
      y += 1;
  }

  public void left() {
    if (y > 0)
      y -= 1;
  }

  public Point() {
    x = 1;
    y = 1;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}
