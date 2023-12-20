package tr.com.d3kod.y_2023.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * Day06
 */
public class Day06 {

  private static Map<Integer, Integer> input = new HashMap<>();

  public static void run() {
    System.out.println("Hello from 2023 Day 06");
    // input.put(7, 9);
    // input.put(15, 40);
    // input.put(30, 200);
    input.put(48, 261);
    input.put(93, 1192);
    input.put(84, 1019);
    input.put(66, 1063);

    stepOne();
    stepTwo();
  }

  private static void stepTwo() {
    int toplam = 0;
    Long time = 48938466L;
    Long distance = 261119210191063L;
    for (Long i = 1L; i <= time; i++) {
      if ((time - i) * i > distance) {
        toplam++;
      }
    }
    System.out.println("2023 step 2 : " + toplam);
  }

  private static void stepOne() {
    int carpim = 1;
    for (Map.Entry<Integer, Integer> e : input.entrySet()) {
      int toplam = 0;
      for (int i = 1; i <= e.getKey(); i++) {
        if ((e.getKey() - i) * i > e.getValue()) {
          toplam++;
        }
      }
      carpim *= toplam;
    }
    System.out.println("2023 Day06 Step One: " + carpim);
  }
}
