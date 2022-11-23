package br.com.emendes.bee2728;

import java.io.IOException;
import java.util.Scanner;

public class GraceHopperAVovoDoCobol {

  public static void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in);

    String line;
    int index;
    char[] cobolLowercase = {'c', 'o', 'b', 'o', 'l'};
    char[] cobolUppercase = {'C', 'O', 'B', 'O', 'L'};
    char start;
    char end;

    while (input.hasNextLine()) {
      line = input.nextLine();
      String[] words = line.split("-");
      index = 0;
      for (String word : words) {
        if (word.length() > 0) {
          start = word.charAt(0);
          end = word.charAt(word.length() - 1);
          if (start == cobolLowercase[index] || start == cobolUppercase[index] || end == cobolLowercase[index] || end == cobolUppercase[index]) {
            index++;
            if (index == 5) {
              System.out.println("GRACE HOPPER");
              break;
            }
          }
        }
      }
      if (index != 5) {
        System.out.println("BUG");
      }
    }

    input.close();
  }

}
