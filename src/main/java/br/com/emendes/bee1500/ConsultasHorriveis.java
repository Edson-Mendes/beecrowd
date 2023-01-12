package br.com.emendes.bee1500;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsultasHorriveis {

  private static final int SEG_TREE_SIZE = 262_144;
  private static long[] segTreeArray;
  private static long[] lazyUpdatesArray;

  public static void main(String[] args) throws IOException {
//    long ini = System.currentTimeMillis();

    Scanner input = new Scanner(System.in);
//    Scanner input = new Scanner(new File("input.txt"));
//    PrintWriter output = new PrintWriter("output.txt");

    int cases = input.nextInt();
    int inputArrayLenght;
    int commandsQuantity;
    int command;
    int indexStart;
    int indexEnd;
    long value;
    int aux;

    while (cases-- > 0) {
      inputArrayLenght = input.nextInt();
      commandsQuantity = input.nextInt();

//      Como o tamanho do array é no max 100_000, então o tamanho max da segTree é 262_144.
      segTreeArray = new long[SEG_TREE_SIZE];
      lazyUpdatesArray = new long[SEG_TREE_SIZE];

      while (commandsQuantity-- > 0) {
        command = input.nextInt();
        indexStart = input.nextInt() - 1;
        indexEnd = input.nextInt() - 1;

        if (indexStart > indexEnd) {
          // Inverte os valores para INDEXSTART ser menor ou igual a INDEXEND
          aux = indexEnd;
          indexEnd = indexStart;
          indexStart = aux;
        }

        if (command == 0) {
          value = input.nextLong();
          updateRange(value, indexStart, indexEnd, inputArrayLenght);
        } else {
          long segmentSum = getRange(indexStart, indexEnd, inputArrayLenght);

//          output.println(segmentSum);
          System.out.println(segmentSum);
        }
      }

    }

    input.close();
//    output.close();

//    long end = System.currentTimeMillis();
//    System.out.println((end - ini));
  }

  private static void updateRange(long value, int updateStart, int updateEnd, int arrayLength) {
    updateRangeUtil(value, updateStart, updateEnd, 0, arrayLength - 1, 0);
  }

  private static void updateRangeUtil(long value, int updateStart, int updateEnd, int segmentStart, int segmentEnd, int indexSegment) {
    // Verificar se existe lazy updates.
    // se SIM, atualizar o node atual e marcar os nodes filhos para lazy updates.
    if (lazyUpdatesArray[indexSegment] != 0) {
      // Atualiza node atual.
      segTreeArray[indexSegment] += (segmentEnd - segmentStart + 1) * lazyUpdatesArray[indexSegment];

      // Verificar se NÃO está em node folha.
      // Se NÃO ESTIVER, marca os nodes filhos para lazy updates
      if (segmentStart != segmentEnd) {
        lazyUpdatesArray[2 * indexSegment + 1] += lazyUpdatesArray[indexSegment];
        lazyUpdatesArray[2 * indexSegment + 2] += lazyUpdatesArray[indexSegment];
      }

      // Remover o lazy update marcado para o node atual.
      lazyUpdatesArray[indexSegment] = 0;
    }

    //Verificar se o segmento está fora do range de update.
    // Se SIM, apenas return.
    if (segmentStart > segmentEnd || segmentEnd < updateStart || segmentStart > updateEnd) return;

    // Verificar se segmento está completamente dentro do range.
    // Se SIM, atualiza node atual, e marca os nodes filhos para lazy updates.
    if (segmentStart >= updateStart && segmentEnd <= updateEnd) {

      // Atualiza node atual.
      segTreeArray[indexSegment] += (segmentEnd - segmentStart + 1) * value;

      // Verificar se NÃO está em node folha.
      // Se NÃO ESTIVER, marca os nodes filhos para lazy updates
      if (segmentStart != segmentEnd) {
        lazyUpdatesArray[2 * indexSegment + 1] += value;
        lazyUpdatesArray[2 * indexSegment + 2] += value;
      }
      return;
    }

    // Se chegar até aqui significa que parte do segmento está dentro do range
    int mid = (segmentEnd + segmentStart) / 2;
    // Atualiza filho da esquerda.
    updateRangeUtil(value, updateStart, updateEnd, segmentStart, mid, 2 * indexSegment + 1);
    // Atualiza filho da direita.
    updateRangeUtil(value, updateStart, updateEnd, mid + 1, segmentEnd, 2 * indexSegment + 2);

    //Após atualizar os nodes filhos, atualiza o node atual.
    segTreeArray[indexSegment] = segTreeArray[2 * indexSegment + 1] + segTreeArray[2 * indexSegment + 2];
  }

  private static long getRange(int rangeStart, int rangeEnd, int arrayLength) {
    return getRangeUtil(rangeStart, rangeEnd, 0, arrayLength - 1, 0);
  }

  private static long getRangeUtil(int rangeStart, int rangeEnd, int segmentStart, int segmentEnd, int indexSegment) {
    // Verificar se existe lazy updates.
    // se SIM, atualizar o node atual e marcar os nodes filhos para lazy updates.
    if (lazyUpdatesArray[indexSegment] != 0) {
      // Atualiza node atual.
      segTreeArray[indexSegment] += (segmentEnd - segmentStart + 1) * lazyUpdatesArray[indexSegment];

      // Verificar se NÃO está em node folha.
      // Se NÃO ESTIVER, marca os nodes filhos para lazy updates
      if (segmentStart != segmentEnd) {
        lazyUpdatesArray[2 * indexSegment + 1] += lazyUpdatesArray[indexSegment];
        lazyUpdatesArray[2 * indexSegment + 2] += lazyUpdatesArray[indexSegment];
      }

      // Remover o lazy update marcado para o node atual.
      lazyUpdatesArray[indexSegment] = 0;
    }

    //Verificar se o segmento está fora do range de update.
    // Se SIM, return 0.
    if (segmentStart > segmentEnd || segmentEnd < rangeStart || segmentStart > rangeEnd) return 0;

    // Verificar se segmento está completamente dentro do range.
    // Se SIM, atualiza node atual, e marca os nodes filhos para lazy updates.
    if (segmentStart >= rangeStart && segmentEnd <= rangeEnd) return segTreeArray[indexSegment];

    // Se chegar até aqui significa que parte do segmento está dentro do range

    int mid = (segmentEnd + segmentStart) / 2;
    // Busca quanto de cada metade está dentro do range, soma e retorna.
    return getRangeUtil(rangeStart, rangeEnd, segmentStart, mid, 2 * indexSegment + 1) +
        getRangeUtil(rangeStart, rangeEnd, mid + 1, segmentEnd, 2 * indexSegment + 2);
  }

}
