package Lista02;

import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor a ser sacado: ");
        int valor = input.nextInt();

        int[] cedulas = {100, 50, 20, 10, 5, 2, 1};

        System.out.println("Cédulas a serem entregues:");

        for (int cedula : cedulas) {
            if (valor >= cedula) {
                int quantidade = valor / cedula;
                valor %= cedula;
                System.out.println(quantidade + " cédula(s) de R$" + cedula);
            }
        }

        input.close();
    }
}
