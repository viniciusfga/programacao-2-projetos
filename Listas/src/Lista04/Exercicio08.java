package Lista04;

public class Exercicio08{

    public static boolean ehPalindromo(String s, int inicio, int fim) {

        if (s == null) {
            throw new IllegalArgumentException("A string não pode ser nula.");
        }

        // Caso base: chegou ao centro - é palíndromo
        if (inicio >= fim) {
            return true;
        }

        // Se os caracteres forem diferentes - não é palíndromo
        if (s.charAt(inicio) != s.charAt(fim)) {
            return false;
        }

        // Chamada recursiva para o próximo par
        return ehPalindromo(s, inicio + 1, fim - 1);
    }


    public static void main(String[] args) {

        try {
            String palavra = "arara";

            boolean resultado = ehPalindromo(palavra, 0, palavra.length() - 1);

            if (resultado)
                System.out.println(palavra + " é um palíndromo.");
            else
                System.out.println(palavra + " NÃO é um palíndromo.");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
