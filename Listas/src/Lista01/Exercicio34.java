package Lista01;

public class Exercicio34 {
    public static void main(String[] args) {

        System.out.println("Verificar se duas palavras são anagramas.");

        String palavra1 = "java";
        String palavra2 = "vaja";
        int cont = 0;

        for (int i = 0; i < palavra1.length(); i++) {
            char c = palavra1.charAt(i);

            for (int j = 0; j < palavra2.length(); j++) {
                if (c == palavra2.charAt(j) ) {
                    cont++;
                    break;
                }
            }
        }
        if (cont == palavra1.length()) {
            System.out.println("São anagramas");
        } else {
            System.out.println("Não são anagramas");
        }

    }
}
