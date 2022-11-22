package br.com.emendes.bee1551;

import java.io.IOException;
import java.util.Scanner;

public class FraseCompleta {

  public static void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in);

    int[] quantity = {0};
    int cases = input.nextInt();
    input.nextLine();


    while (cases-- > 0) {
      boolean[] letters = new boolean[26];
      quantity[0] = 0;
      String phrase = input.nextLine();

      try {
        phrase.codePoints().forEach(i -> {
          int value = i - 97;
          if (value > -1 && !letters[value]) {
            letters[value] = true;
            quantity[0]++;
            if (quantity[0] == 26) throw new RuntimeException();

          }
        });

        if(quantity[0] >= 13) System.out.println("frase quase completa");
        else System.out.println("frase mal elaborada");
      } catch (RuntimeException ex){
        System.out.println("frase completa");
      }
    }

    input.close();
  }

}
