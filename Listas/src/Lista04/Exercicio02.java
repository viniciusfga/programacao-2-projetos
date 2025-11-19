package Lista04;

public class Exercicio02 {

    public static boolean ehPrimoRecursivo(int n, int divisor) {

        // Caso base: números menores que 2 não são primos
        if (n < 2) throw new IllegalArgumentException("O número deve ser maior que 1.");;

        // Se o divisor chegou na raiz do número, ele é primo
        if (divisor * divisor > n) return true;

        // Se encontrou divisor, não é primo
        if (n % divisor == 0) return false;

        // Chamada recursiva testando próximo divisor
        return ehPrimoRecursivo(n, divisor + 1);
    }

    public static boolean ehPrimo(int n) {
        return ehPrimoRecursivo(n, 2);
    }


    public static void main(String[] args) {

        int a = 1;

        try {
            if (ehPrimo(a))
                System.out.println(a + " é primo");
            else
                System.out.println(a + " não é primo");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
