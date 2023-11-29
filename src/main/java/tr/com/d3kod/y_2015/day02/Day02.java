package tr.com.d3kod.y_2015.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day02 {

    private static int paper = 0;
    private static int ribbon = 0;

    public static void run() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("./resources/15_day02.txt"));
            String line = reader.readLine();

            while (line != null) {
                // System.out.println(line);
                hesapla(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sonuc Paper:::::::::::::::     " + paper);
        System.out.println("Sonuc Ribbon:::::::::::::::     " + ribbon);
    }

    public static void hesapla(String ebatlar) {
        String[] ebats = ebatlar.split("x");
        int e[] = new int[] {
                Integer.parseInt(ebats[0]),
                Integer.parseInt(ebats[1]),
                Integer.parseInt(ebats[2]),
        };
        calculatePaper(e);
        calculateRibbon(e);

    }

    private static void calculateRibbon(int[] e) {
        Arrays.sort(e);
        ribbon += 2 * (e[0] + e[1]) + e[0] * e[1] * e[2];
    }

    private static void calculatePaper(int[] e) {
        int a1 = e[0] * e[1];
        int a2 = e[0] * e[2];
        int a3 = e[1] * e[2];
        int k = Math.min(a1, Math.min(a2, a3));
        paper = paper + k + 2 * (a1 + a2 + a3);
    }

}
