package Mes1;

public class Exercicio333 {
    public static void main(String[] args) {

        // Fórmula de Machin
        double pi = 16.0 * Math.atan(1.0 / 5.0) - 4.0 * Math.atan(1.0 / 239.0);

        System.out.printf("Valor aproximado de π: %.10f%n", pi);

        /*
        System.out.println("Encontre um valor aproximado do valor de π (pi) usando a série de Leibniz");

        double pi = 0.0;
        double diferenca = 0.00000000005;
        double anterior;

        int i = 0; // contador de termos

        do {
            anterior = pi;
            if (i % 2 == 0) {
                pi += 4.0 / (2 * i + 1); // termo positivo
            } else {
                pi -= 4.0 / (2 * i + 1); // termo negativo
            }
            i++;
            System.out.println("Valor aproximado: " + pi);
        } while (Math.abs(pi - anterior) > diferenca);

        System.out.println("\nValor final aproximado de π: " + pi);
        */

    }
}
