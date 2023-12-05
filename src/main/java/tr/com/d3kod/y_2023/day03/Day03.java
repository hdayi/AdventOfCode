package tr.com.d3kod.y_2023.day03;

import java.util.List;

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

    for (int i = 0; i < input.size(); i++) {
      String line = input.get(i);
      for (int j = 0; j < line.length(); j++) {
        if (Character.isDigit(line.charAt(j))) {

        }
      }
      System.out.println("");

    }

    System.out.println("2023 Day 03 step 1: " + sum);
  }

  private static void int foundDigit(int i, int j){
    
  }
}
