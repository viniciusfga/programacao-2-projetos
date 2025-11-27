package Excecao;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Peça dois números ao usuário e trate a divisão por zero.
     */
public class Exercicio06 {

    public static double dividir(double A, double B){
        if(B == 0){
            throw  new ArithmeticException("Divisão por zero não permitida!");
        }
        return A / B;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro número: ");
            double a = input.nextDouble();

            System.out.print("Digite o segundo número: ");
            double b = input.nextDouble();

            dividir(a, b);

            double resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e){
            System.out.println("Erro: Não é possível dividir por zero!");
        } catch (Exception e){
            System.out.println("Entrada inválida. Digite apenas números.");
        } finally {
            System.out.println("Operação finalizada.");
            input.close();
        }

    }
}
