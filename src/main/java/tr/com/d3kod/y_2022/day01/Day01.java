package tr.com.d3kod.y_2022.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Day01
 */
public class Day01 {

  private static List<Integer> caloryByElf = new ArrayList<>();

  public static void run() {
    System.out.println("Hello 2022 Day 01");
    readCaloryByElf();
    stepOne();
    stepTwo();
  }

  private static void stepTwo() {
    int total = 0;
    int max = caloryByElf.stream().mapToInt(c -> c).max().orElse(-1);
    caloryByElf.remove(caloryByElf.indexOf(max));
    total += max;

    max = caloryByElf.stream().mapToInt(c -> c).max().orElse(-1);
    caloryByElf.remove(caloryByElf.indexOf(max));
    total += max;

    max = caloryByElf.stream().mapToInt(c -> c).max().orElse(-1);
    caloryByElf.remove(caloryByElf.indexOf(max));
    total += max;
    System.out.println("2022 Day01 Step 2: " + total);

  }

  private static void stepOne() {
    int max = caloryByElf.stream().mapToInt(c -> c).max().orElse(-1);
    System.out.println("2022 Day01 Step 1: " + max);
  }

  private static void readCaloryByElf() {

    BufferedReader reader;
    int toplam = 0;

    try {
      reader = new BufferedReader(new FileReader("./resources/22_day01.txt"));
      String line = reader.readLine();
      toplam += Integer.parseInt(line);

      while (line != null) {
        line = reader.readLine();
        if (line == null)
          break;
        if (line.equals("")) {
          caloryByElf.add(toplam);
          toplam = 0;
        } else {
          toplam += Integer.parseInt(line);
        }
      }

      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }
}
