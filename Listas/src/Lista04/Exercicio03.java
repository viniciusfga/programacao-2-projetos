package Lista04;

public class Exercicio03 {

    public static int somaDigitos(int n){

        if (n == Integer.MIN_VALUE) {
            // Caso extremo que causaria erro ao usar Math.abs
            throw new IllegalArgumentException("Número muito grande para processar.");
        }

        n = Math.abs(n);

        if (n < 0) {
            throw new IllegalArgumentException("Número inválido.");
        }

        // Caso base: se tiver só um dígito
        if (n < 10) {
            return n;
        }
        // Último dígito + soma do restante 112
        return (n % 10) + somaDigitos(n / 10);
    }

    public static void main(String[] args) {

        try {
            int numero = 523;
            int resultado = somaDigitos(numero);
            System.out.println("Resultado: " + resultado);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

}
