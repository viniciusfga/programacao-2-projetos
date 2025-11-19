package Lista04;

public class Exercicio01 {


    public static void collatzIterativo(int n) {

        // Enquanto o número ainda não chegou em 1, continua a lógica da sequência
        while (n != 1) {
            System.out.println(n);

            if (n % 2 == 0) {
                // Se for par, divide por 2
                n = n / 2;
            } else {
                // Se for ímpar, aplica a fórmula 3n + 1
                n = n * 3 + 1;
            }
        }

        System.out.println(1);
    }

    public static void collatzRecursivo(int n) {
        System.out.println(n);

        // Validação: Collatz não funciona para números menores ou iguais a zero
        if (n <= 0) {
            throw new IllegalArgumentException("O número deve ser maior que zero.");
        }

        // Caso base: quando chega em 1, encerra a recursão
        if (n == 1) return;

        if (n % 2 == 0) {
            collatzRecursivo(n / 2);
        } else {
            collatzRecursivo(n * 3 + 1);
        }
    }

    public static void main(String[] args) {

        int a = 7;

        System.out.println("Recursivo:");
        try {
            collatzRecursivo(a);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\nIterativo:");
        collatzIterativo(a);

    }
}