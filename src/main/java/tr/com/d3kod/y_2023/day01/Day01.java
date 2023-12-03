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

    String[] rakamlar = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        // "1", "2", "3", "4", "5", "6", "7", "8", "9",
    };

    // input.clear();
    // input.add("two1nine");
    // input.add("eightwothree");
    // input.add("abcone2threexyz");
    // input.add("xtwone3four");
    // input.add("4nineeightseven2");
    // input.add("zoneight234");
    // input.add("7pqrstsixteen");
    int sum = 0;
    Pattern p = Pattern.compile("\\d+");

    for (String line : input) {
      String oldLine = line;
      for (int i = 0; i < line.length(); i++) {
        if (Character.isDigit(line.charAt(i))) {
          continue;
        }
        for (int j = 0; j < rakamlar.length; j++) {
          String rakam = rakamlar[j];
          if (i + rakam.length() > line.length())
            continue;
          String sub = line.substring(i, i + rakam.length());
          if (sub.indexOf(rakam) > -1) {
            line = line.replaceFirst(rakam, Integer.toString(j));
            break;
          }
        }
      }

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
    //
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
