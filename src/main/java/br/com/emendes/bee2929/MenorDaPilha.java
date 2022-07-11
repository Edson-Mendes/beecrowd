package br.com.emendes.bee2929;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenorDaPilha {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(System.in);
//    long start = System.currentTimeMillis();
//    Scanner input = new Scanner(new File("input.txt"));
//    PrintWriter output = new PrintWriter("output.txt");

    int numeroOperacoes = Integer.parseInt(input.nextLine());
    String operacao;
    final String empty = "EMPTY";
    Stack stack = new Stack(numeroOperacoes);
    int result;
    while (numeroOperacoes-- > 0) {
      operacao = input.nextLine();
      switch (operacao) {
        case "POP":
          if (stack.pop() == -1) {
//            output.println(empty);
            System.out.println(empty);
          }
          break;
        case "MIN":
          result = stack.min();
          if (result != -1) {
//            output.println(result);
            System.out.println(result);
          } else {
//            output.println(empty);
            System.out.println(empty);
          }
          break;
        default:
          stack.push(Integer.parseInt(operacao.substring(5)));
      }

    }

    input.close();
//    output.close();

//    long end = System.currentTimeMillis();
//    System.out.println(end - start);
  }

  static class Stack {

    int size = 0;
    int[] giftStack;
    int min = 1000000001;

    public Stack(int maxSize) {
      giftStack = new int[maxSize];
    }

    public void push(int diversao) {
      if (diversao < min) {
        min = diversao;
      }
      giftStack[size++] = diversao;
    }

    public int pop() {
      if (size == 0) {
        return -1;
      }
      int toBePoped = giftStack[--size];
      if (toBePoped == min) {
        min = findMin();
      }
      return toBePoped;
    }

    public int min() {
      if (size == 0) {
        return -1;
      }
      return min;
    }

    private int findMin() {
      int smaller = 1000000001;
      for (int i = 0; i < size; i++) {
        if (giftStack[i] < smaller) smaller = giftStack[i];
      }
      return smaller;
    }

  }

}
