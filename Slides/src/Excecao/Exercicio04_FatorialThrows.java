package Excecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio04_FatorialThrows {

    public static int fatorial(int n) throws IllegalArgumentException, ArithmeticException {

        if (n < 0) {
            throw new IllegalArgumentException("Não existe fatorial de número negativo!");
        }

        int resultado = 1;

        for (int i = 2; i <= n; i++) {
            // Verifica se a multiplicação vai ultrapassar o limite de int
            if (resultado > Integer.MAX_VALUE / i) {
                throw new ArithmeticException("Número muito grande para int!");
            }
            resultado *= i;
        }

        return resultado;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero = 0;

        try {
            System.out.print("Digite um número: ");
            numero = input.nextInt();

            int resultado = fatorial(numero);
            System.out.println("Fatorial: " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("Erro: você deve digitar apenas números inteiros!");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Erro ao calcular fatorial: " + e.getMessage());
        }
    }
}
