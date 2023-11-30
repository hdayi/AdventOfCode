package tr.com.d3kod.y_2019.day01;

import java.util.List;

import tr.com.d3kod.util.ReadFile;

/**
 * Day01
 */
public class Day01 {

  private static List<Integer> input;
  private static int totalFuel;
  private static int secondFuel;

  public static void run() {
    System.out.println("Hello 2019 day01");

    input = ReadFile.readFileInt("19_day01.txt");
    stepOne();
    System.out.println("2019 Day01 step 1: " + totalFuel);
    stepTwo();
    System.out.println("2019 Day01 step 2: " + (secondFuel));

  }

  private static int calculate(int mass, boolean step1) {
    int n = mass / 3 - 2;
    if (step1) {
      return n;
    } else {
      return n > 0 ? n + calculate(n, false) : 0;
    }
  }

  private static void stepTwo() {
    secondFuel = input
        .stream()
        .mapToInt(
            mass -> calculate(mass, false))
        .sum();
  }

  private static void stepOne() {
    totalFuel = input.stream()
        .mapToInt(
            mass -> calculate(mass, true))
        .sum();
  }
}
