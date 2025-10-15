package PROVA01;

import java.util.Scanner;

public class ConjecturaGoldbach {

    // Método para verificar se um número é primo
    public static boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Método que verifica a conjectura de Goldbach para um número
    public static void verificarGoldbach(int numero) {
        if (numero <= 2 || numero % 2 != 0) {
            System.out.println("Informe um número par maior que 2.");
            return;
        }

        boolean encontrado = false;
        for (int i = 2; i <= numero / 2; i++) {
            int j = numero - i;
            if (ehPrimo(i) && ehPrimo(j)) {
                System.out.println(numero + " = " + i + " + " + j);
            }
            encontrado = true;
        }

        if (!encontrado) {
            System.out.println("Nenhuma combinação encontrada..");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número par maior que 2: ");
        int numero = sc.nextInt();

        verificarGoldbach(numero);
    }
}
