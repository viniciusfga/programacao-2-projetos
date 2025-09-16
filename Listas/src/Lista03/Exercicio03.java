package Lista03;

public class Exercicio03 {
    /*
    Conte quantas ocorrências de uma substring aparecem em outra String (sobreposição opcional).
     */
    static int contarComSobreposicao(String texto, String sub) {
        int count = 0;

        for (int i = 0; i <= texto.length() - sub.length(); i++) {
            if (texto.regionMatches(i, sub, 0, sub.length())) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String texto = "aaaa";
        String sub = "aa";
        System.out.println(contarComSobreposicao(texto, sub)); // 3
    }
}
