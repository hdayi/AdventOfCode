package tr.com.d3kod.y_2018.day01;

import java.util.ArrayList;
import java.util.List;

import tr.com.d3kod.util.ReadFile;

public class Day01 {

  private static List<String> liste;

  public static void run() {
    System.out.println("hello 2018 day01");

    liste = ReadFile.readFile("18_day01.txt");

    System.out.print("2018 day01 step 1 answer: ");
    stepOne();
    System.out.print("2018 day01 step 2 answer: ");
    stepTwo();
  }

  private static void stepTwo() {
    int total = 0;
    boolean found = false;
    List<Integer> frekans = new ArrayList<>();
    frekans.add(0);

    while (!found) {
      for (int i = 0; i < liste.size(); i++) {
        String s = liste.get(i);
        total += Integer.parseInt(s);
        if (frekans.contains(total)) {
          found = true;
          break;
        }
        frekans.add(total);
      }

    }
    System.out.print(total);
  }

  private static void stepOne() {
    int total = 0;
    for (int i = 0; i < liste.size(); i++) {
      String s = liste.get(i);
      total += Integer.parseInt(s);
    }
    System.out.println(total);
  }
}
