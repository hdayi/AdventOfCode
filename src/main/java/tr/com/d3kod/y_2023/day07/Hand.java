package tr.com.d3kod.y_2023.day07;

import java.util.HashMap;
import java.util.Map;

/**
 * Card
 */
public class Hand {

  private Map<String, Integer> cards = new HashMap<>();
  private int bid;

  public Hand(String value) {
    String[] h = value.split(" ");
    bid = Integer.parseInt(h[1]);
    for (int i = 0; i < 4; i++) {
      String card = h[0].substring(i, i + 1);
      if (cards.containsKey(card)) {
        cards.put(card, cards.get(card) + 1);
      } else {
        cards.put(card, 1);
      }
    }
  }

}
