package tr.com.d3kod.y_2023.day02;

class Setler {
  private int redCount;
  private int blueCount;
  private int greenCount;

  public Setler(String set) {
    String[] balls = set.split(",");
    for (int i = 0; i < balls.length; i++) {
      String[] b = balls[i].split(" ");

      if (b[2].equals("red")) {
        redCount = Integer.parseInt(b[1]);
      }
      if (b[2].equals("blue")) {
        blueCount = Integer.parseInt(b[1]);
      }
      if (b[2].equals("green")) {
        greenCount = Integer.parseInt(b[1]);
      }
    }
  }

  public int getRedCount() {
    return redCount;
  }

  public int getBlueCount() {
    return blueCount;
  }

  public int getGreenCount() {
    return greenCount;
  }

}
