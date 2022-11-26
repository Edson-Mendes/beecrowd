package br.com.emendes.bee2292;

import java.io.IOException;
import java.util.Scanner;

public class PainelLED {

  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);

    int cases = input.nextInt();
    input.nextLine();
    String line;
    char[] lamps;
    long alt;

    while (cases-- > 0) {
      line = input.nextLine();
      String[] inputs = line.split(" ");

      lamps = inputs[0].toCharArray();
      alt = Long.parseLong(inputs[1]);

      for (int p = 0; p < lamps.length && alt > 0; p++) {
        long lamp = lamps[p] == 'X' ? 0 : 1;
        long state = (lamp + alt) % 2;
        alt = (lamp + alt) >> 1;
        lamps[p] = state == 0 ? 'X' : 'O';
      }
      System.out.println(String.valueOf(lamps));
    }

    input.close();
  }

}
