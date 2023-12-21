package tr.com.d3kod.y_2023.day07;

import java.util.HashMap;
import java.util.Map;

/**
 * Card
 */
public class Hand {

  private Map<String, Integer> cards = new HashMap<>();
  private int bid;
  private int value;
  private Map<String, Integer> cValues = new HashMap<>();

  public Hand(String value) {
    String[] h = value.split(" ");
    bid = Integer.parseInt(h[1]);
    for (int i = 0; i < 5; i++) {
      String card = h[0].substring(i, i + 1);
      if (cards.containsKey(card)) {
        cards.put(card, cards.get(card) + 1);
      } else {
        cards.put(card, 1);
      }
    }
    for (int i = 1; i < 10; i++) {
      cValues.put(Integer.toString(i), i);
    }
    cValues.put("T", 10);
    cValues.put("J", 11);
    cValues.put("Q", 12);
    cValues.put("K", 13);
    cValues.put("A", 14);

    calculateValue();
  }

  private void calculateValue() {
    for (Map.Entry<String, Integer> e : cards.entrySet()) {
      int v = cValues.get(e.getKey()) * (int) Math.pow(15, e.getValue());
      value += v;
    }
  }

  public int getBid() {
    return bid;
  }

  public int getValue() {
    return value;
  }

}
