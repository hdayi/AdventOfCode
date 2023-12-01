package tr.com.d3kod.y_2017.day02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import tr.com.d3kod.util.ReadFile;

/**
 * Day02
 */
public class Day02 {

  private static List<String> input;

  public static void run() {
    System.out.println("Hello from 2017 day2");
    input = ReadFile.readFile("17_day02.txt");
    stepOne();
  }

  private static void stepOne() {
    int total = 0;
    int total2 = 0;
    for (String line : input) {
      String[] numbers = line.split("\t");
      List<Integer> nums = Arrays.asList(numbers)
          .stream()
          .mapToInt(
              n -> Integer.parseInt(n))
          .boxed()
          .collect(Collectors.toList());
      int max = nums.stream().mapToInt(c -> c).max().orElse(-999999999);
      int min = nums.stream().mapToInt(c -> c).min().orElse(-999999999);
      total += max - min;
      // step2
      for (int i = 0; i < nums.size(); i++) {
        for (int j = 0; j < nums.size(); j++) {
          if (i != j) {
            int num1 = nums.get(i);
            int num2 = nums.get(j);
            int div = num1 / num2;
            float fDiv = (float) num1 / (float) num2;
            if (fDiv - div == 0) {
              total2 += div;
              break;
            }
          }
        }
      }
    }
    System.out.println("2017 Day02 Step 1: " + total);
    System.out.println("2017 Day02 Step 2: " + total2);
  }
}
