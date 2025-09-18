package Lista03;


public class Exercicio09 {

    static void MameDAgua(String texto) {
        String[] musica = texto.split(" ");

        // Quantidade de palavras em cada linha, na ordem que você quer imprimir
        int[] linhas = {
                2, // Yeah eu
                4,
                5,
                7,
                9,
                11,
                9,
                8,
                6,
                5,
                4,
                3,
                2
        };

        // imprime as linhas de acordo com o vetor
        for (int qtd : linhas) {
            for (int j = 0; j < qtd && j < musica.length; j++) {
                System.out.print(musica[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String musica = "Yeah eu te amo muito mas agora é tarde eu vou dormir";
        MameDAgua(musica);
    }
}
