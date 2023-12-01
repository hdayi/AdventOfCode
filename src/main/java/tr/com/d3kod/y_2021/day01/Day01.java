package tr.com.d3kod.y_2021.day01;

import java.util.List;

import tr.com.d3kod.util.ReadFile;

/**
 * Day01
 */
public class Day01 {

  private static List<Integer> input;

  public static void run() {
    System.out.println("Hello 2021 Day01");
    input = ReadFile.readFileInt("21_day01.txt");
    stepOne();
    stepTwo();
  }

  private static void stepTwo() {
    int count = 0;
    for (int i = 0; i < input.size(); i++) {
      if (i < input.size() - 3) {
        int first = input.get(i) + input.get(i + 1) + input.get(i + 2);
        int second = input.get(i + 1) + input.get(i + 2) + input.get(i + 3);
        if (first < second)
          count++;
      }
    }
    System.out.println("2021 Day 01 Step 1: " + count);
  }

  private static void stepOne() {
    int count = 0;
    for (int i = 0; i < input.size(); i++) {
      if (i < input.size() - 1 && input.get(i) < input.get(i + 1)) {
        count++;
      }
    }
    System.out.println("2021 Day 01 Step 1: " + count);
  }
}
