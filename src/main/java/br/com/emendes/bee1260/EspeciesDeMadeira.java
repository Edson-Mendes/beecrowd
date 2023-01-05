package br.com.emendes.bee1260;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EspeciesDeMadeira {

  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);

    Map<String, Quantity> trees = new HashMap<>();
    String line;

    input.nextLine();
    input.nextLine();

    while (input.hasNextLine()) {
      line = input.nextLine();
      if (line.isEmpty()) {
        printResult(trees);
        System.out.println();
        trees = new HashMap<>();
        Quantity.total = 0;
      } else {
        Quantity quantity = trees.get(line);
        Quantity.total++;
        if (quantity == null) {
          trees.put(line, new Quantity());
        } else {
          quantity.value++;
        }
      }
    }
    printResult(trees);

    input.close();
  }

  private static void printResult(Map<String, Quantity> trees) {
    List<String> list = trees.keySet().stream().sorted().collect(Collectors.toList());
    BigDecimal percentage;
    for (String tree : list) {
      Quantity quantity = trees.get(tree);
      percentage = BigDecimal.valueOf(quantity.getPercentage() * 100).setScale(4, RoundingMode.HALF_UP);
      System.out.printf("%s %s%n", tree, percentage);
    }
  }

  private static class Quantity {

    public static double total = 0;

    public double value = 1;

    public double getPercentage() {
      return value / total;
    }

  }

}
