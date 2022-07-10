package br.com.emendes.bee1303;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SpursRocks {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(System.in);
//    Scanner input = new Scanner(new File("input.txt"));
//    PrintWriter output = new PrintWriter("output.txt");
    int quantidadeTimes = input.nextInt();
    int quantidadeJogos;
    int idA, idB, pontosA, pontosB;
    int index;
    int instancia = 1;
    while (quantidadeTimes != 0) {
      quantidadeJogos = quantidadeTimes * (quantidadeTimes - 1) / 2;
      List<Time> tabela = new ArrayList<>(quantidadeTimes);
      for (index = 1; index <= quantidadeTimes; index++) {
        tabela.add(new Time(index));
      }
      while (quantidadeJogos-- > 0) {
        idA = input.nextInt();
        pontosA = input.nextInt();
        idB = input.nextInt();
        pontosB = input.nextInt();

        Time timeA = tabela.get(idA - 1);
        Time timeB = tabela.get(idB - 1);

        if (pontosA > pontosB) {
          timeA.pontuacao += 2;
          timeB.pontuacao++;
        } else {
          timeB.pontuacao += 2;
          timeA.pontuacao++;
        }
        timeA.cestasAFavor += pontosA;
        timeA.cestasContra += pontosB;
        timeB.cestasAFavor += pontosB;
        timeB.cestasContra += pontosA;
      }
      if(instancia > 1){
//        output.println();
        System.out.println();
      }
      Collections.sort(tabela);
//      output.printf("Instancia %d%n", instancia++);
      System.out.printf("Instancia %d%n", instancia++);

      for (index = 0; index < quantidadeTimes; index++) {
        if (index == quantidadeTimes - 1) {
//          output.println(tabela.get(index).id);
          System.out.println(tabela.get(index).id);
        } else {
//          output.printf("%d ", tabela.get(index).id);
          System.out.printf("%d ", tabela.get(index).id);
        }
      }
      quantidadeTimes = input.nextInt();
    }
    input.close();
//    output.close();
  }

  static class Time implements Comparable<Time> {
    public int id;
    public int pontuacao;
    public double cestasAFavor;
    public double cestasContra;

    public Time(int id) {
      this.id = id;
    }

    @Override
    public int compareTo(Time other) {
      if(this.pontuacao > other.pontuacao) return -1;
      if(this.pontuacao < other.pontuacao) return 1;

      double cestaAverageA = cestasContra == 0 ? cestasAFavor : cestasAFavor / cestasContra;
      double cestaAverageB = other.cestasContra == 0 ? other.cestasAFavor : other.cestasAFavor / other.cestasContra;

      if (cestaAverageA > cestaAverageB) return -1;
      if (cestaAverageA < cestaAverageB) return 1;

      if (cestasAFavor > other.cestasAFavor) return -1;
      if (cestasAFavor < other.cestasAFavor) return 1;

      return this.id - other.id;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Time time = (Time) o;
      return id == time.id &&
          pontuacao == time.pontuacao &&
          Double.compare(time.cestasAFavor, cestasAFavor) == 0 &&
          Double.compare(time.cestasContra, cestasContra) == 0;
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, pontuacao, cestasAFavor, cestasContra);
    }
  }

}
