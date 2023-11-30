package tr.com.d3kod.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadFile
 */
public class ReadFile {

  public static String readOneLine(String fileName) {
    BufferedReader reader;
    String line = null;
    try {
      reader = new BufferedReader(new FileReader("./resources/" + fileName));
      line = reader.readLine();
      reader.close();
      return line;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return line;
  }

  public static List<String> readFile(String fileName) {
    BufferedReader reader;
    List<String> sonuc = new ArrayList<>();

    try {
      reader = new BufferedReader(new FileReader("./resources/" + fileName));
      String line = reader.readLine();
      sonuc.add(line);

      while (true) {
        line = reader.readLine();
        if (line == null)
          break;
        sonuc.add(line);
      }

      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sonuc;
  }
}
