package Lista02;

public class Exercicio05 {
    public static void main(String[] args) {

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

    }
}
