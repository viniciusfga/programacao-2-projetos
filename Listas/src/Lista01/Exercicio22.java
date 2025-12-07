package Lista01;

public class Exercicio22 {
    public static void main(String[] args) {

        System.out.println("Verificar se um número é palíndromo.");

        int numero = 21;
        String numeroStr = Integer.toString(numero);
        String novoNumero = "";

        for (int i = numeroStr.length() - 1; i >= 0 ; i--) {
            char letra = numeroStr.charAt(i);
            novoNumero += letra + "";
        }
        if (!numeroStr.equals(novoNumero)) {
            System.out.println("O número " + novoNumero + " não é palíndromo.");
            return;
        }
        System.out.println("O número " + novoNumero + " é palíndromo.");

    }
}
