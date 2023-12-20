package tr.com.d3kod.y_2023.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * MainMap
 */
public class MainMap {

  private List<Long> source = new ArrayList<>();
  private List<Long> dest = new ArrayList<>();
  private List<Long> range = new ArrayList<>();

  public Long getDest(Long s) {
    for (int i = 0; i < this.source.size(); i++) {

      if (s >= this.source.get(i) &&
          s < this.source.get(i) + this.range.get(i)) {
        return this.dest.get(i) + s - this.source.get(i);
      }
    }
    return s;
  }

  public void add(Long source, Long destination, Long range) {
    this.source.add(source);
    this.dest.add(destination);
    this.range.add(range);
  }
}
