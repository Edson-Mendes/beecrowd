package br.com.emendes.bee1062;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Trilhos {

  private static Stack lineA = new Stack();
  private static Stack lineB = new Stack();

  public static void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in);
//    Scanner input = new Scanner(new File("input.txt"));
//    PrintWriter output = new PrintWriter("output.txt");

    int wagonsNumber;
    int nextWagon;
    int wagon;

    wagonsNumber = input.nextInt();
    input.nextLine();

    while (wagonsNumber > 0) {
      lineA.topIndex = -1;
      lineB.topIndex = -1;
      readTrain(input.nextLine());
      if (lineA.top() == 0) {
        wagonsNumber = Integer.parseInt(input.nextLine());
//        output.println();
        System.out.println();
      } else {
        // TODO: resolução do problema!
        nextWagon = wagonsNumber;

        while (lineA.hasNext() || lineB.top() == nextWagon) {
          wagon = lineB.top();
          if(wagon == nextWagon) {
            lineB.pop();
            nextWagon--;
          } else {
            wagon = lineA.pop();
            if (wagon == nextWagon) {
              nextWagon--;
            } else {
              lineB.push(wagon);
            }
          }
        }

        if (nextWagon == 0) {
//          output.println("Yes");
          System.out.println("Yes");
        } else {
//          output.println("No");
          System.out.println("No");
        }
      }
    }

    input.close();
//    output.close();
  }

  private static void readTrain(String input) {
    String[] lineAAsString = input.split(" ");
    for (String wagon : lineAAsString) {
      lineA.push(Integer.parseInt(wagon));
    }
  }

  private static class Stack {

    private final int[] array = new int[1000];
    public int topIndex = -1;

    public void push(int value) {
      array[++topIndex] = value;
    }

    public int pop() {
      if (topIndex < 0) return -1;
      return array[topIndex--];
    }

    public int top() {
      if (topIndex < 0) return -1;
      return array[topIndex];
    }

    public boolean hasNext() {
      return topIndex > -1;
    }

    private void printArray() {
      for (int i = 0; i <= topIndex; i++) {
        System.out.printf("%d ", array[i]);
      }
      System.out.println();
    }

  }

}
