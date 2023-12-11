package tr.com.d3kod.y_2023.day03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tr.com.d3kod.util.ReadFile;

/**
 * Day03
 */
public class Day03 {

  private static List<String> input;

  public static void run() {
    System.out.println("Hello from 2023 day 03");
    input = ReadFile.readFile("23_day03.txt");
    stepOne();

  }

  private static void stepOne() {
    int sum = 0;
    int sum2 = 0;
    Pattern p = Pattern.compile("\\d+");

    Map<Point, Integer> secondPart = new HashMap<>();

    for (int i = 0; i < input.size(); i++) {
      String line = input.get(i);

      Matcher m = p.matcher(line);

      while (m.find()) {
        String match = m.group(0);
        int j = line.indexOf(match);
        Point point = isValidPart(i, j, match);
        int mMatch = Integer.parseInt(match);
        if (point != null) {
          if (point.isStar()) {
            if (secondPart.containsKey(point)) {
              sum2 += mMatch * secondPart.get(point);
              secondPart.remove(point);
            } else {
              secondPart.put(point, mMatch);
            }
          }
          sum += mMatch;
        }
        String replacement = "";
        // If same number is repeating in the same line it finds first one so
        // we must replace every number we find with same amount of dots
        for (int k = 0; k < match.length(); k++) {
          replacement += ".";
        }
        line = line.replaceFirst(match, replacement);
      }
    }

    System.out.println("2023 Day 03 step 1: \t\t" + sum);
    System.out.println("2023 Day 03 step 2: \t\t" + sum2);
  }

  // what if we return coordinate of star ????
  private static Point isValidPart(int i, int j, String num) {
    int satirStart = i == 0
        ? 0
        : i - 1;
    int sutunStart = j == 0
        ? 0
        : j - 1;
    // bu dahil;
    int satirSon = i == input.size() - 1
        ? i
        : i + 1;
    int sutunSon = j + num.length() >= input.get(i).length() - 1
        ? input.get(i).length() - 1
        : j + num.length();

    String line = input.get(satirStart).substring(sutunStart, sutunSon + 1);
    if (satirStart + 1 <= satirSon) {
      line += input.get(satirStart + 1).substring(sutunStart, sutunSon + 1);
    }
    if (satirStart + 2 <= satirSon) {
      line += input.get(satirStart + 2).substring(sutunStart, sutunSon + 1);
    }
    line = line.replaceAll("\\.", "").replaceAll("\\d", "");

    // we must find the position of the char
    if (line.equals("*")) {
      for (int k = satirStart; k <= satirSon; k++) {
        line = input.get(k);
        for (int k2 = sutunStart; k2 <= sutunSon; k2++) {
          if (line.charAt(k2) == '*')
            return new Point(k, k2, true);
        }
      }
    } else {
      return new Point(-1, -1, false);
    }
    return null;

  }

}

class Point {

  private boolean isStar;
  private int x;
  private int y;

  public Point(int x, int y, boolean isStar) {
    this.x = x;
    this.y = y;
    this.isStar = isStar;
  }

  public boolean isStar() {
    return isStar;
  }

  public void setStar(boolean isStar) {
    this.isStar = isStar;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
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
    if (obj == null)
      return false;
    Point other = (Point) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

}
