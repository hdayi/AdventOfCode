package tr.com.d3kod.y_2018.day02;

import java.util.HashMap;
import java.util.List;

import tr.com.d3kod.util.ReadFile;

/**
 * Day02
 */
public class Day02 {

  private static List<String> input;

  public static void run() {
    System.out.println("Hello from 2018 day 02");
    input = ReadFile.readFile("18_day02.txt");
    stepOne();
  }

  private static void stepOne() {
    int sum = 0;
    int c2 = 0;
    int c3 = 0;

    for (String line : input) {
      boolean f2 = false;
      boolean f3 = false;

      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }

      for (Character c : map.keySet()) {
        int sayi = map.get(c);
        if (map.get(c) == 2 && !f2) {
          c2++;
          f2 = true;
        }
        if (map.get(c) == 3 && !f3) {
          c3++;
          f3 = true;
        }
      }
    }
    sum = c2 * c3;
    System.out.println("2018 day02 step 1: " + sum);
  }
}
