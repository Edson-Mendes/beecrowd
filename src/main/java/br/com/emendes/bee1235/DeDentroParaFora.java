package br.com.emendes.bee1235;

import java.util.Scanner;

// Desafio 1235
public class DeDentroParaFora {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int cases = Integer.parseInt(input.nextLine());
    while (cases-- > 0) {
      char[] line = input.nextLine().toCharArray();
      int lineSize = line.length / 2;
      char[] answer = new char[line.length];
      int j = 0;
      for (int i = lineSize - 1; i > -1; i--) {
        answer[j++] = line[i];
      }
      for(int i = line.length-1;i>=lineSize;i--){
        answer[j++] = line[i];
      }
      System.out.println(answer);
    }
  }
}
