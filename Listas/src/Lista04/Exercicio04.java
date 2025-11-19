package Lista04;

public class Exercicio04 {

    public static double potencia(int base, int expoente) {

        if (base == 0 && expoente < 0) {
            throw new IllegalArgumentException("0 não pode ser elevado a expoente negativo.");
        }

        // Caso base 1: qualquer número elevado a 0 = 1
        if (expoente == 0) {
            return 1;
        }

        // Caso expoente negativo: usa recursão com expoente positivo
        if (expoente < 0) {
            return 1.0 / potencia(base, -expoente);
        }

        // Caso recursivo: base * potência(base, expoente - 1)
        return base * potencia(base, expoente - 1);
    }

    public static void main(String[] args) {

        try {
            int base = 2;
            int exp = 5;

            double resultado = potencia(base, exp);
            System.out.println(base + "^" + exp + " = " + resultado);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
