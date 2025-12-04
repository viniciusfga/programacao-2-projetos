package ListaTeste;

public class Teste {

    /*
   3 - Desenvolva uma função recursiva para calcular a soma dos dígitos de um número inteiro.
     */
    public static boolean verify(String word, int begin, int end) {
        if (word.length() <= 1) return true;
        if(begin > end) return true;

        if (word.charAt(begin) != word.charAt(end - 1)) {
            return false;
        }

        return verify(word, begin + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println(verify("arara", 0, 5));

    }
}
