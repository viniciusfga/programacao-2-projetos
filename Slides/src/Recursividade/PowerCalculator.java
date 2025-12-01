package Recursividade;

import java.util.InputMismatchException;
import java.util.Scanner;

    /*
        Escreva um programa que contenha um método
        recursivo que receba dois números inteiros
        positivos k e n e calcule k^n.
    */
public class PowerCalculator {

    // Exceção personalizada
    public static class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }
    }

    // Método recursivo que calcula k^n
    public static int calculateNumericalPower(int base, int exponent) throws NegativeNumberException {
        if (base < 0 || exponent < 0) {
            throw new NegativeNumberException("Nenhum dos números pode ser negativo.");
        }

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        return base * calculateNumericalPower(base, exponent - 1);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Digite dois números inteiros positivos: BASE e EXPOENTE");
            int base = input.nextInt();
            int exponent = input.nextInt();

            int result = calculateNumericalPower(base, exponent);
            System.out.println("Resultado: " + result);

        } catch (InputMismatchException err) {
            System.err.println("Erro: informe apenas números inteiros!");
        } catch (NegativeNumberException e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            input.close(); // Boa prática
        }
    }
}
