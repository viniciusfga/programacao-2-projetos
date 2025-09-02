package Lista02;

import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número binário: ");
        String binario = input.nextLine();

        int decimal = 0;
        int tamanho = binario.length();

        for (int i = 0; i < tamanho; i++) {
            char c = binario.charAt(tamanho - 1 - i);
            if (c == '1') {
                decimal += Math.pow(2, i);
            } else if (c != '0') {
                System.out.println("Número binário inválido!");
                input.close();
                return;
            }
        }

        System.out.println("O número decimal é: " + decimal);
        input.close();
    }
}
