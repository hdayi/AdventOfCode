package tr.com.d3kod.y_2017.day01;

import tr.com.d3kod.util.ReadFile;

/**
 * Day01
 */
public class Day01 {

  public static void run() {
    System.out.println("hello 2017");
    String input = ReadFile.readOneLine("17_day01.txt");
    System.out.print("2017 step 1 answer: ");
    stepOne(input, 1);
    System.out.print("2017 step 2 answer: ");
    stepOne(input, input.length() / 2);
    // System.out.println(input.length());
  }

  private static void stepOne(String input, int step) {
    int total = 0;
    for (int i = 0; i < input.length(); i++) {
      int first = 0;
      int second = 0;
      first = Integer.parseInt(Character.toString(input.charAt(i)));
      second = Integer.parseInt(Character.toString(input.charAt((i + step) % input.length())));

      if (first == second) {
        total += first;
      }
    }
    System.out.println(total);
  }
}
