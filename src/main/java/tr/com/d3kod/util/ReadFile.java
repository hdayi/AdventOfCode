package tr.com.d3kod.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
}
