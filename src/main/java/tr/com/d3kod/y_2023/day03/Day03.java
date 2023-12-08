package tr.com.d3kod.y_2023.day03;

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
    // "...$.*....",
    // ".664.598.."));
    stepOne();
  }

  private static void stepOne() {
    int sum = 0;
    int sum2 = 0;
    Pattern p = Pattern.compile("\\d+");

    for (int i = 0; i < input.size(); i++) {
      String line = input.get(i);

      Matcher m = p.matcher(line);

      while (m.find()) {
        String match = m.group(0);
        sum2 += Integer.parseInt(match);
        int j = line.indexOf(match);
        if (isValidPart(i, j, match)) {
          sum += Integer.parseInt(match);
        }
      }
    }

    System.out.println("2023 Day 03 step 1: \t\t" + sum);
    System.out.println("2023 Day 03 step 1 all of it: \t" + sum2);
  }

  private static boolean isValidPart(int i, int j, String num) {
    int satirStart = i == 0
        ? 0
        : i - 1;
    int sutunStart = j == 0
        ? 0
        : j - 1;
    // bu dahil;
    int satirSon = i == input.size() - 1
        ? i
        : i + 1;
    int sutunSon = j + num.length() >= input.get(i).length() - 1
        ? input.get(i).length() - 1
        : j + num.length();

    String line = input.get(satirStart).substring(sutunStart, sutunSon + 1);
    if (satirStart + 1 <= satirSon) {
      line += input.get(satirStart + 1).substring(sutunStart, sutunSon + 1);
    }
    if (satirStart + 2 <= satirSon) {
      line += input.get(satirStart + 2).substring(sutunStart, sutunSon + 1);
    }
    line = line.replaceAll("\\.", "").replaceAll("\\d", "");

    return line.length() > 0;
  }

}
