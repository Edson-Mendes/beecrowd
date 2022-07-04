package br.com.emendes.bee1077;

import java.util.Scanner;
import java.util.Stack;

public class InfixaParaPosfixa {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int casos = Integer.parseInt(input.nextLine());
    char[] line;
    while(casos-- > 0){
      line = input.nextLine().toCharArray();
      System.out.println(infixaToPosfixa(line));
    }
    input.close();
  }

  public static StringBuilder infixaToPosfixa(char[] infixa){

    Stack<Integer> pilha = new Stack<>();

    StringBuilder posfixa = new StringBuilder();
    int contador = 0;
    char elemento;

    while(contador < infixa.length){
      elemento = infixa[contador++];

      switch (elemento) {
        case '+', '-', '*', '/', '^' -> {
          while (!pilha.empty() && prioridade(elemento) <= prioridade((char) (int) pilha.peek())) {
            posfixa.append((char) (int) pilha.pop());
          }
          pilha.add((int) elemento);
        }
        case '(' -> pilha.add((int) elemento);
        case ')' -> {
          while ((char) (int) pilha.peek() != '(') {
            posfixa.append((char) (int) pilha.pop());
          }
          pilha.pop();
        }
        default -> posfixa.append(elemento);
      }
    }
    while(!pilha.isEmpty()){
      elemento = (char)(int)pilha.pop();
      if(elemento != '('){
        posfixa.append(elemento);
      }
    }
    return posfixa;
  }

  public static int prioridade(char elemento){
    return switch (elemento) {
      case '-', '+' -> 1;
      case '*', '/' -> 2;
      case '^' -> 3;
      default -> 0;
    };
  }

}
