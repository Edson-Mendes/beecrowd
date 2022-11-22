package br.com.emendes.bee2690;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NovaSenhaRA {

  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);

    Map<Integer, Integer> map = generateMap();

    int cases = input.nextInt();
    int[] quantidade = new int[1];
    input.nextLine();

    while (cases-- > 0) {
      String password = input.nextLine();
      quantidade[0] = 0;

      try {
        password.codePoints().forEach(c -> {
          if (c != 32) {
            System.out.print(map.get(c));
            quantidade[0]++;
            if (quantidade[0] == 12) throw new RuntimeException();
          }
        });
      } catch (RuntimeException ignored){}
      finally {
        System.out.println();
      }
    }

    input.close();
  }

  private static Map<Integer, Integer> generateMap() {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(71, 0);
    map.put(81, 0);
    map.put(97, 0);
    map.put(107, 0);
    map.put(117, 0);

    map.put(73, 1);
    map.put(83, 1);
    map.put(98, 1);
    map.put(108, 1);
    map.put(118, 1);

    map.put(69, 2);
    map.put(79, 2);
    map.put(89, 2);
    map.put(99, 2);
    map.put(109, 2);
    map.put(119, 2);

    map.put(70, 3);
    map.put(80, 3);
    map.put(90, 3);
    map.put(100, 3);
    map.put(110, 3);
    map.put(120, 3);

    map.put(74, 4);
    map.put(84, 4);
    map.put(101, 4);
    map.put(111, 4);
    map.put(121, 4);

    map.put(68, 5);
    map.put(78, 5);
    map.put(88, 5);
    map.put(102, 5);
    map.put(112, 5);
    map.put(122, 5);

    map.put(65, 6);
    map.put(75, 6);
    map.put(85, 6);
    map.put(103, 6);
    map.put(113, 6);

    map.put(67, 7);
    map.put(77, 7);
    map.put(87, 7);
    map.put(104, 7);
    map.put(114, 7);

    map.put(66, 8);
    map.put(76, 8);
    map.put(86, 8);
    map.put(105, 8);
    map.put(115, 8);

    map.put(72, 9);
    map.put(82, 9);
    map.put(106, 9);
    map.put(116, 9);

    return map;
  }

}
