package tr.com.d3kod.y_2020.day01;

import java.util.List;

import tr.com.d3kod.util.ReadFile;

/**
 * Day01
 */
public class Day01 {

  private static List<Integer> input;
  private static int result = 0;

  public static void run() {
    System.out.println("Hello 2020 Day01");
    input = ReadFile.readFileInt("20_day01.txt");
    stepOne();
    stepTwo();
  }

  private static void stepTwo() {
    result = 0;
    for (Integer num : input) {
      for (Integer n : input) {
        for (Integer nu : input) {
          if (num + n + nu == 2020) {
            result = num * n * nu;
            System.out.println("2020 Day01 step 1: " + result);
            break;
          }
        }

        if (result != 0)
          break;
      }

      if (result != 0)
        break;
    }
  }

  private static void stepOne() {
    result = 0;
    for (Integer num : input) {
      for (Integer n : input) {
        if (num + n == 2020) {
          result = num * n;
          System.out.println("2020 Day01 step 1: " + result);
          break;
        }
        if (result != 0)
          break;
      }
    }
  }
}
