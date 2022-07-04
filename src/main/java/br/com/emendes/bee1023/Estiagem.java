package br.com.emendes.bee1023;

import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

public class Estiagem {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int qtdImoveis;
    int numeroCidade = 1;

    qtdImoveis = input.nextInt();
    while (qtdImoveis != 0) {
      int[] mediaConsumo = new int[201];
      int totalPessoas = 0;
      int totalConsumo = 0;
      int pessoas;
      int consumo;
      while (qtdImoveis-- > 0) {
        pessoas = input.nextInt();
        consumo = input.nextInt();

        mediaConsumo[consumo / pessoas] += pessoas;
        totalPessoas += pessoas;
        totalConsumo += consumo;
      }

      StringBuilder pessoasPorConsumo = new StringBuilder("");
      for (int i = 0; i < 201; i++) {
        if (mediaConsumo[i] > 0) {
          pessoasPorConsumo.append(mediaConsumo[i]).append("-").append(i).append(" ");
        }
      }
      pessoasPorConsumo.setCharAt(pessoasPorConsumo.length() - 1, '\n');
      BigDecimal mediaGeral = new BigDecimal(totalConsumo).divide(new BigDecimal(totalPessoas), 2, RoundingMode.FLOOR);
      if(numeroCidade > 1){
        System.out.println();
      }
      System.out.printf("Cidade# %d:%n", numeroCidade++);
      System.out.print(pessoasPorConsumo);
      System.out.printf("Consumo medio: %s m3.%n", mediaGeral);
      qtdImoveis = input.nextInt();
    }
    input.close();
  }

}
