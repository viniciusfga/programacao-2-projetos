package Lista02;

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = input.nextInt();

        int soma = 0;
        int n = Math.abs(numero);

        while (n > 0) {
            int digito = n % 10;
            soma += digito;
            n /= 10;
        }

        System.out.println("A soma dos dígitos é: " + soma);
        input.close();
    }
}
