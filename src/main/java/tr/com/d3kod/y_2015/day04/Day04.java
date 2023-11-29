package tr.com.d3kod.y_2015.day04;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day04
 */
public class Day04 {

  public static void run() {

    System.out.print("5 digit answer is::::: ");
    findMagicNumber(5);
    System.out.print("6 digit answer is::::: ");
    findMagicNumber(6);
  }

  private static void findMagicNumber(int digitCount) {
    String secret = "ckczppom";
    Pattern pattern = Pattern.compile("^0{" + digitCount + "}");
    MessageDigest md;
    try {
      md = MessageDigest.getInstance("MD5");
      for (int i = 0; i >= 0; i++) {
        String number = secret + i;
        md.update(number.getBytes());
        byte[] digest = md.digest();
        String sonuc = toHex(digest);
        Matcher matcher = pattern.matcher(sonuc);
        if (matcher.find()) {
          System.out.println(i);

          break;
        }
      }
    } catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static String toHex(byte[] bytes) {
    BigInteger bi = new BigInteger(1, bytes);
    return String.format("%0" + (bytes.length << 1) + "X", bi);
  }
}
