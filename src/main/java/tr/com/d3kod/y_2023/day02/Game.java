package tr.com.d3kod.y_2023.day02;

import java.util.ArrayList;
import java.util.List;

class Game {
  private int id;
  private List<Setler> sets;

  private int minRedCount = 0;
  private int minBlueCount = 0;
  private int minGreenCount = 0;

  public boolean isValidGame() {
    boolean valid = true;
    for (Setler s : sets) {
      valid = valid && s.getRedCount() <= 12 &&
          s.getBlueCount() <= 14 &&
          s.getGreenCount() <= 13;
    }
    return valid;
  }

  public int getPower() {
    return minBlueCount * minGreenCount * minRedCount;
  }

  public void addSet(Setler set) {
    if (sets == null) {
      sets = new ArrayList<>();
    }

    if (set.getRedCount() > minRedCount) {
      minRedCount = set.getRedCount();
    }
    if (set.getGreenCount() > minGreenCount) {
      minGreenCount = set.getGreenCount();
    }
    if (set.getBlueCount() > minBlueCount) {
      minBlueCount = set.getBlueCount();
    }
    sets.add(set);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Setler> getSets() {
    return sets;
  }

}
