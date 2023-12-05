package tr.com.d3kod.y_2023.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tr.com.d3kod.util.ReadFile;

/**
 * Day02
 */
public class Day02 {

  private static List<String> input;
  private static List<Game> games;

  public static void run() {
    System.out.println("hello form 2023 day 2");
    input = ReadFile.readFile("23_day02.txt");
    // input = new ArrayList<>(
    // Arrays.asList("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
    // "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
    // "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
    // "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
    // "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
    convertGames();
    stepOne();
    stepTwo();
  }

  private static void stepTwo() {
    int sum = 0;
    for (Game game : games) {
      sum += game.getPower();
    }
    System.out.println("2023 Day02 setp 2: " + sum);
  }

  private static void stepOne() {
    int sum = 0;
    for (Game game : games) {
      if (game.isValidGame()) {
        sum += game.getId();
      }
    }
    System.out.println("2023 Day02 Step 1: " + sum);
  }

  private static void convertGames() {
    games = new ArrayList<>();
    for (String line : input) {
      String[] first = line.split(":");
      Game g = new Game();
      g.setId(
          Integer.parseInt(
              first[0].replaceAll("\\D", "")));

      String[] sets = first[1].split(";");
      for (int i = 0; i < sets.length; i++) {
        Setler set = new Setler(sets[i]);
        g.addSet(set);

      }

      games.add(g);
    }

  }
}
