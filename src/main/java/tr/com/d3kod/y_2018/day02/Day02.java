package tr.com.d3kod.y_2018.day02;

import java.util.ArrayList;
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
    stepTwo();
  }

  private static void stepTwo() {
    boolean isFound = false;
    for (int i = 0; i < input.size() - 1; i++) {
      if (isFound) {
        break;
      }
      var line = input.get(i);
      for (int j = i + 1; j < input.size(); j++) {
        int pos = -1;
        var sLine = input.get(j);
        var difCount = 0;
        for (int k = 0; k < line.length(); k++) {
          if (line.charAt(k) != sLine.charAt(k)) {
            difCount++;
            pos = k;
          }
        }
        if (difCount == 1) {
          StringBuilder sb = new StringBuilder(line);
          line = sb.deleteCharAt(pos).toString();
          System.out.println("2018 Day 02 Step 2: " + line);
          isFound = true;
          break;
        }
      }
    }
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
