package tr.com.d3kod.y_2023.day04;

/**
 * MainMap
 */
public class MainMap {

  private int sourceStart;
  private int destStart;
  private int range;

  public int getSourceStart() {
    return sourceStart;
  }

  public int getDestStart() {
    return destStart;
  }

  public int getRange() {
    return range;
  }

  public MainMap(int sourceStart, int destStart, int range) {
    this.sourceStart = sourceStart;
    this.destStart = destStart;
    this.range = range;
  }

  public int getDestination(int source) {
    int dif = source - sourceStart;
    if (dif > range)
      return -1;
    // if( )
    return -1;
  }
}
