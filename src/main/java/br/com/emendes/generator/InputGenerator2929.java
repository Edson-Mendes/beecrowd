package br.com.emendes.generator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class InputGenerator2929 {

  public static void main(String[] args) throws FileNotFoundException {
    PrintWriter output = new PrintWriter("input.txt");
    System.out.println("Entre com a quantidade de operações:");
    Scanner input = new Scanner(System.in);

    int inputSize = input.nextInt();
    output.println(inputSize);

    while (inputSize-- > 0){
      Random random = new Random();
      int option = random.nextInt(1, 5);
      switch (option) {
        case 1 -> output.println("MIN");
        case 2 -> output.println("POP");
        default -> {
          int giftValue = random.nextInt(1, 1001);
          output.printf("PUSH %d%n", giftValue);
        }
      }
    }

    output.close();
  }

}
