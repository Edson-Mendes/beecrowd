package br.com.emendes.bee2025;

import java.util.Scanner;

public class Joulupukki {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    final String NAME = "oulupukk";
    final char j = 'J';
    final char i = 'i';

    int index;
    int size;

    int linesAmount = Integer.parseInt(input.nextLine());
    while (linesAmount-- > 0) {
      index = 0;
      StringBuilder line = new StringBuilder(input.nextLine());
      index = line.indexOf(NAME, index);
      size = line.length();
      while (index != -1) {
        if (index == 1) {
          if (index + 9 < size) {
            if (line.charAt(index + 8) == ' ' || line.charAt(index + 9) == ' ' || line.charAt(index + 9) == '.') {
              line.setCharAt(0, j);
              line.setCharAt(index + 8, i);
            }
          } else {
            line.setCharAt(0, j);
            if (index + 8 == size) {
              line.append(i);
            } else {
              line.setCharAt(index + 8, i);
            }
          }
        } else if (index > 1 && (line.charAt(index - 1) == ' ' || line.charAt(index - 2) == ' ')) {

          if (index + 9 < size) {
            if (line.charAt(index + 8) == ' ' || line.charAt(index + 9) == ' ' || line.charAt(index + 9) == '.') {
              line.setCharAt(index-1, j);
              line.setCharAt(index + 8, i);
            }
          } else {
            line.setCharAt(index-1, j);
            if (index + 8 == size) {
              line.append(i);
            } else {
              line.setCharAt(index + 8, i);
            }
          }
        }
        index = line.indexOf(NAME, index + 9);
      }

      System.out.println(line);
    }
  }

  public static StringBuilder precessLine(StringBuilder line) {
    final char j = 'J';
    final char i = 'i';
    final String NAME = "oulupukk";
    int index = 0;

    index = line.indexOf(NAME, index);
    int size = line.length();
    while (index != -1) {
//      Caso index = 0
//      Não faça nada

//      Caso index = 1 e index+8 < size
//      Testa para o lado direito
      if (index == 1) {
        if (index + 9 < size) {
          if (line.charAt(index + 8) == ' ' || line.charAt(index + 9) == ' ' || line.charAt(index + 9) == '.') {
            line.setCharAt(0, j);
            line.setCharAt(index + 8, i);
          }
        } else {
          line.setCharAt(0, j);
          if (index + 8 == size) {
            line.append(i);
          } else {
            line.setCharAt(index + 8, i);
          }
        }
      } else if (index > 1 && (line.charAt(index - 1) == ' ' || line.charAt(index - 2) == ' ')) {

        if (index + 9 < size) {
          if (line.charAt(index + 8) == ' ' || line.charAt(index + 9) == ' ' || line.charAt(index + 9) == '.') {
            line.setCharAt(index-1, j);
            line.setCharAt(index + 8, i);
          }
        } else {
          line.setCharAt(index-1, j);
          if (index + 8 == size) {
            line.append(i);
          } else {
            line.setCharAt(index + 8, i);
          }
        }
      }
      index = line.indexOf(NAME, index + 9);
    }
    return line;

  }

}
