package Lista01;

public class Exercicio16 {
    public static void main(String[] args) {

        System.out.println("Contar vogais em uma string.");

        char[] vogais = {'a', 'e', 'i', 'o', 'u'};

        String palavra = "java";
        int cont = 0;

        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);
            for (int j = 0; j < palavra.length(); j++) {
                if (palavra.charAt(i) == vogais[j]) {
                    cont++;
                }
            }
        }
        System.out.println("Quantidade de vogais " + cont);

    }
}
