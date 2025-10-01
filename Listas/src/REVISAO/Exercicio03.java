package REVISAO;

import java.util.Scanner;

public class Exercicio03 {
    /*
    Dado um conjunto de números inteiros com até 8 dígitos, verifique se cada um é feliz ou infeliz.
    Um número é feliz se, ao substituir repetidamente o número pela soma dos quadrados de seus dígitos,
     o resultado final for 1. Caso o processo entre em um ciclo que não inclua o 1, o número é infeliz.

    Exemplo:
    19 é feliz, pois:
    1² + 9² = 82 → 8² + 2² = 68 → 6² + 8² = 100 → 1² + 0² + 0² = 1.
     */

    static String verificarNumeroFeliz(int n) {
        while (n != 1 && n != 4) { // se chegar em 4, sabemos que é infeliz
            int soma = 0;
            int temp = n;
            while (temp > 0) {
                int digito = temp % 10;
                soma += digito * digito;
                temp /= 10;
            }
            n = soma;
        }
        return (n == 1) ? "Feliz" : "Infeliz";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = sc.nextInt();

        System.out.println(verificarNumeroFeliz(numero));

        sc.close();
    }
}
