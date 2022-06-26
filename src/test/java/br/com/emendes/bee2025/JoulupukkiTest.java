package br.com.emendes.bee2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit tests for Joulupukki (2025)")
class JoulupukkiTest {

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer1(){
    StringBuilder input = new StringBuilder("oulupukk");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "oulupukk";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer2(){
    StringBuilder input = new StringBuilder("Joulupukk oulupukku");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "Joulupukkioulupukku";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer3(){
    StringBuilder input = new StringBuilder("oulupukk oulupukku");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "oulupukkJoulupukki";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer4(){
    StringBuilder input = new StringBuilder("oulupukk");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "oulupukk";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer5(){
    StringBuilder input = new StringBuilder("oulupukk Joulupukk oulupukku");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "oulupukk Joulupukkioulupukku";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer6(){
    StringBuilder input = new StringBuilder("EEoulupukkAA");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "EEoulupukkAA";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer7(){
    StringBuilder input = new StringBuilder("edson mendes oulupukk");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "edson mendesJoulupukki";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer8(){
    StringBuilder input = new StringBuilder("edson mendes    oulupukk");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "edson mendes   Joulupukki";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer9(){
    StringBuilder input = new StringBuilder("Eoulupukk");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "Joulupukki";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer10(){
    StringBuilder input = new StringBuilder("Foulupukki mielellaan saa kirjetta. doulupukkA.");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "Joulupukki mielellaan saa kirjetta. Joulupukki.";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer11(){
    StringBuilder input = new StringBuilder("Joulupukku JOULUPUKKU... Joulupukku Joulupukku");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "Joulupukki JOULUPUKKU... Joulupukki Joulupukki";

    Assertions.assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("processLine must return the rigth answer")
  void processLine_mustReturnsTheRightAnswer12(){
    StringBuilder input = new StringBuilder("Joulupukk. Joulupukku Joulupukku Joulupukku");
    StringBuilder output = Joulupukki.precessLine(input);
    String expected = "Joulupukki Joulupukki Joulupukki Joulupukki";

    Assertions.assertEquals(expected, output.toString());
  }

}