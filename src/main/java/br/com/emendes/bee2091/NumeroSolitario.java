package br.com.emendes.bee2091;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class NumeroSolitario {

  public static void main(String[] args) throws FileNotFoundException {
//    long start = System.currentTimeMillis();
    Scanner input = new Scanner(System.in);
//    Scanner input = new Scanner(new File("input.txt"));
//    PrintWriter output = new PrintWriter("output.txt");

    int n = input.nextInt();
    int index;
    long[] array;
    int aux;
    while (n != 0){
      array = new long[n];
      index = 0;
      while(index < n){
        array[index++] = input.nextLong();
      }
      Arrays.sort(array);
//      output.println(semPar(array, n));
      System.out.println(semPar(array, n));
      n = input.nextInt();
    }

    input.close();
//    output.close();
//    long end = System.currentTimeMillis();
//    System.out.println(end - start);
  }

  public static long semPar(long[] array, int n){
    int index = 1;
    while(index < n){
      if(array[index] != array[index-1]){
        return array[index-1];
      }
      index += 2;
    }
    return array[index-1];
  }

}
