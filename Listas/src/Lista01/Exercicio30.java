package Lista01;

import java.util.Scanner;

public class Exercicio30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calcular raiz quadrada com método de Newton.");

        System.out.print("Digite o número para calcular a raiz quadrada: ");
        double N = sc.nextDouble();

        if (N < 0) {
            System.out.println("Não é possível calcular a raiz quadrada de número negativo.");
            sc.close();
            return;
        }

        double x = N / 2.0;
        double tolerancia = 1e-6;
        double numero;
        do {
            numero = 0.5 * (x + N / x);

            if (Math.abs(numero - x) < tolerancia) {
                break;
            }
            x = numero;
        } while (true);

        System.out.println("Raiz quadrada de " + N + " ≈ " + numero);

        sc.close();

    }
}
