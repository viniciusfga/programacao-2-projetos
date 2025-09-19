package Lista03;


public class Exercicio08_v2 {
    /*
        Faça um programa que use laços de repetição para imprimir a música de Walter Franco, Mame D’Agua.
        Yeah eu 2
        Yeah eu te amo 4
        Yeah eu te amo muito 5
        Yeah eu te amo muito mas 6
        Yeah eu te amo muito mas agora 7
        Yeah eu te amo muito mas agora é tarde 9
        Yeah eu te amo muito mas agora é tarde eu vou
        Yeah eu te amo muito mas agora é tarde eu vou dormir
        Yeah eu te amo muito mas agora é tarde eu vou
        Yeah eu te amo muito mas agora é tarde
        Yeah eu te amo muito mas agora
        Yeah eu te amo muito mas
        Yeah eu te amo muito
        Yeah eu te amo
        Yeah eu
        */
    static void MameDAgua(String texto) {
        String[] musica = texto.split(" ");

        int[] linhas = {
                2, // Yeah eu
                4, // Yeah eu te amo
                5,
                6,
                7,
                9,
                11,
                9,
                7,
                6,
                5,
                4,
                2
        };

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
