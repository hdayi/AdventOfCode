package tr.com.d3kod.y_2023.day03;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tr.com.d3kod.util.ReadFile;

/**
 * Day03
 */
public class Day03 {

  private static List<String> input;

  public static void run() {
    System.out.println("Hello from 2023 day 03");
    input = ReadFile.readFile("23_day03.txt");
    // input = new ArrayList<>(
    // Arrays.asList(
    // "467..114..",
    // "...*......",
    // "..35..633.",
    // "......#...",
    // "617*......",
    // ".....+.58.",
    // "..592.....",
    // "......755.",
    // "...$.*...w",
    // "4664.598.8"));
    stepOne();
  }

  private static void stepOne() {
    List<String> liste = new ArrayList<>();
    int sum = 0;
    Pattern p = Pattern.compile("\\d+");

    for (int i = 0; i < input.size(); i++) {
      String line = input.get(i);

      Matcher m = p.matcher(line);

      while (m.find()) {
        String match = m.group(0);
        int j = line.indexOf(match);
        if (isValidPart(i, j, match)) {
          sum += Integer.parseInt(match);
        }
      }
    }

    System.out.println("2023 Day 03 step 1: " + sum);
  }

  private static boolean isValidPart(int i, int j, String num) {
    int satirStart = i == 0 ? 0 : i - 1;
    int sutunStart = j == 0 ? 0 : j - 1;
    // bu dahil;
    int satirSon = i == input.size() - 1 ? i : i + 1;
    int sutunSon = j + num.length() >= input.get(i).length() - 1 ? input.get(i).length() - 1 : j + num.length();

    for (int k = satirStart; k <= satirSon; k++) {
      System.out.println(input.get(k).substring(satirStart, satirSon );
    }

    for (int k = satirStart; k <= satirSon; k++) {
      for (int l = sutunStart; l <= sutunSon; l++) {
        char c = input.get(k).charAt(l);
        if (!Character.isDigit(c) && c != '.') {
          return true;
        }
      }
    }
    return false;
  }

}
