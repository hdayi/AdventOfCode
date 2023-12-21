package tr.com.d3kod.y_2023.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tr.com.d3kod.util.ReadFile;

/**
 * Day07
 */
public class Day07 {

  private static List<String> input;
  private static List<Hand> hands = new ArrayList<>();

  public static void run() {
    System.out.println("Hello from 2023 Day 07");
    input = ReadFile.readFile("23_day07.txt");
    input = new ArrayList<>(
        Arrays.asList(
            "32T3K 765",
            "T55J5 684",
            "KK677 28",
            "KTJJT 220",
            "QQQJA 483"));
    for (String line : input) {
      hands.add(new Hand(line));
    }
    Collections.sort(hands, new HandComparator());
    stepOne();
  }

  private static void stepOne() {
    int sum = 0;
    for (int i = 0; i < hands.size(); i++) {
      sum += (i + 1) * hands.get(i).getBid();
    }
    System.out.println("2023 Day 07 step one: " + sum);
  }
}

/**
 * InnerDay07
 */
class HandComparator implements Comparator<Hand> {

  @Override
  public int compare(Hand h1, Hand h2) {
    return h1.getValue() - h2.getValue();
  }

}
