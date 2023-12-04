package tr.com.d3kod.y_2023.day01;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tr.com.d3kod.util.ReadFile;

/**
 * Day01
 */
public class Day01 {

  private static List<String> input;

  public static void run() {
    System.out.println("Hello form 2023 Day 01");
    input = ReadFile.readFile("23_day01.txt");
    stepOne();
    stepTwo();
  }

  private static void stepTwo() {

    int sum = 0;
    String[] numWords = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    String[] numReplace = { "o1e", "t2o", "t3e", "f4r", "f5e", "s6x", "s7n", "e8t", "n9e" };

    for (String line : input) {

      for (int index = 0; index < numWords.length; index++) {
        line = line.replace(numWords[index], numReplace[index]);
      }

      line = line.replaceAll("\\D", "");
      String firstInt = line.substring(0, 1);
      String lastInt = line.substring(line.length() - 1);
      sum += Integer.parseInt(firstInt + lastInt);
    }
    System.out.println("2023 Day 01 Step 2: " + sum);
  }

  private static void stepOne() {
    Pattern p = Pattern.compile("\\d+");
    int sum = 0;
    for (String line : input) {
      Matcher m = p.matcher(line);
      String nums = "";
      while (m.find()) {
        nums += m.group();
      }
      int numForLine = Integer.parseInt(
          Character.toString(nums.charAt(0))
              + Character.toString(nums.charAt(nums.length() - 1)));
      sum += numForLine;
    }
    System.out.println("2023 Day 01 Step 1: " + sum);
  }
}
