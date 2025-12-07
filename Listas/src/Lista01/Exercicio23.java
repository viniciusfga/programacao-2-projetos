package Lista01;

public class Exercicio23 {
    public static void main(String[] args) {

        System.out.println("Contar frequência de caracteres em uma string.");

        String palavra = "java";
        char[] letra = new char[palavra.length()];
        int[] frequencia = new int[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            letra[i] = palavra.charAt(i);
        }
        for (int i = 0; i < palavra.length(); i++) {
            for (int j = 0; j < palavra.length(); j++) {
                if (letra[i] == letra[j]) {
                    frequencia[i]++;
                }
            }
        }
        
        for (int i = 0; i < palavra.length(); i++) {
            System.out.println("Letra: " + letra[i] + " - Frequência: " + frequencia[i]);
        }

    }
}
