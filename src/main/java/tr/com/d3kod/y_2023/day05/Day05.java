package tr.com.d3kod.y_2023.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tr.com.d3kod.util.ReadFile;

public class Day05 {

  private static Pattern p = Pattern.compile("\\d+");
  private static List<Long> seeds = new ArrayList<>();
  private static Map<Long, Long> sSeed = new HashMap<>();

  private static MainMap seedToSoil = new MainMap();
  private static MainMap soilToFertilizer = new MainMap();
  private static MainMap fertilizerToWater = new MainMap();
  private static MainMap waterToLight = new MainMap();
  private static MainMap lightToTemp = new MainMap();
  private static MainMap tempToHumidity = new MainMap();
  private static MainMap humidityToLocation = new MainMap();
  private static MainMap pointer;

  private static List<String> input = ReadFile.readFile("23_day05.txt");

  public static void run() {
    System.out.println("Hello from 2023 day 5");

    // input = new ArrayList<>(
    // Arrays.asList("seeds: 79 14 55 13",
    // "",
    // "seed-to-soil map:",
    // "50 98 2",
    // "52 50 48",
    // "",
    // "soil-to-fertilizer map:",
    // "0 15 37",
    // "37 52 2",
    // "39 0 15",
    // "",
    // "fertilizer-to-water map:",
    // "49 53 8",
    // "0 11 42",
    // "42 0 7",
    // "57 7 4",
    // "",
    // "water-to-light map:",
    // "88 18 7",
    // "18 25 70",
    // "",
    // "light-to-temperature map:",
    // "45 77 23",
    // "81 45 19",
    // "68 64 13",
    // "",
    // "temperature-to-humidity map:",
    // "0 69 1",
    // "1 0 69",
    // "",
    // "humidity-to-location map:",
    // "60 56 37",
    // "56 93 4"));
    generateData();
    stepOne();
    stepTwo();
  }

  private static void stepTwo() {
    Long min = -1L;
    for (int i = 0; i < seeds.size(); i += 2) {
      for (int j = 0; j < seeds.get(i + 1); j++) {
        Long location = humidityToLocation.getDest(
            tempToHumidity.getDest(
                lightToTemp.getDest(
                    waterToLight.getDest(
                        fertilizerToWater.getDest(
                            soilToFertilizer.getDest(
                                seedToSoil.getDest(
                                    seeds.get(i) + j)))))));

        if (min == -1) {
          min = location;
        } else {
          if (location < min) {
            min = location;
          }
        }
      }
      System.out.print(".");
    }
    System.out.println("\n2023 day 05 step two: " + min);
  }

  private static void generateData() {
    for (String line : input) {
      if (line.indexOf("seeds") > -1) {
        generateSeeds(line);
        pointer = null;
      }
      if (line.indexOf("seed-to-soil map:") > -1) {
        pointer = seedToSoil;
      }

      if (line.indexOf("soil-to-fertilizer map:") > -1) {
        pointer = soilToFertilizer;
      }
      if (line.indexOf("fertilizer-to-water map:") > -1) {
        pointer = fertilizerToWater;
      }
      if (line.indexOf("water-to-light map") > -1) {
        pointer = waterToLight;
      }
      if (line.indexOf("light-to-temperature map") > -1) {
        pointer = lightToTemp;
      }
      if (line.indexOf("temperature-to-humidity map") > -1) {
        pointer = tempToHumidity;
      }
      if (line.indexOf("humidity-to-location map") > -1) {
        pointer = humidityToLocation;
      }
      // simdi parcalama zamani
      if (pointer != null) {
        Matcher m = p.matcher(line);
        if (m.find()) {
          Long dest = Long.parseLong(m.group());
          m.find();
          Long source = Long.parseLong(m.group());
          m.find();
          Long range = Long.parseLong(m.group());
          pointer.add(source, dest, range);
        }
      }
    }

  }

  private static void stepOne() {
    // List<Long> lozacations = new ArrayList<>();
    Long min = -1L;
    for (int i = 0; i < seeds.size(); i++) {
      Long location = humidityToLocation.getDest(
          tempToHumidity.getDest(
              lightToTemp.getDest(
                  waterToLight.getDest(
                      fertilizerToWater.getDest(
                          soilToFertilizer.getDest(
                              seedToSoil.getDest(
                                  seeds.get(i))))))));
      if (min == -1) {
        min = location;
      } else {
        if (location < min) {
          min = location;
        }
      }
    }
    System.out.println("2023 day 05 step one: " + min);
  }

  private static void generateSeeds(String line) {
    Matcher m = p.matcher(line);
    while (m.find()) {
      String match = m.group();
      Long a = Long.parseLong(match);
      seeds.add(a);
    }
  }
}
