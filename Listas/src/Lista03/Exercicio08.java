package Lista03;

public class Exercicio08 {
    /*
    Faça um programa que use laços de repetição para imprimir a música de Walter Franco, Mame D’Agua.
    Yeah eu 2
    Yeah eu te amo 2
    Yeah eu te amo muito 1
    Yeah eu te amo muito mas 1
    Yeah eu te amo muito mas agora 1
    Yeah eu te amo muito mas agora é tarde 2
    Yeah eu te amo muito mas agora é tarde eu vou 2
    Yeah eu te amo muito mas agora é tarde eu vou dormir 1
    Yeah eu te amo muito mas agora é tarde eu vou 2
    Yeah eu te amo muito mas agora é tarde 2
    Yeah eu te amo muito mas agora 1
    Yeah eu te amo muito mas 1
    Yeah eu te amo muito 1
    Yeah eu te amo 2
    Yeah eu 2
    2 - 2 - 1 - 1 - 1 - 2 - 2 - 1
    (0 - 1) (2 - 3) - 4 - 5 - 6 (7 - 8) (9 - 10) + 11

    */
    static void MameDAgua(String texto) {
        String[] musica = texto.split(" ");

        System.out.println(musica.length);
        System.out.println();

        int contador = 0;

        for (int i = 0; i < 8; i++) {
            if (contador == 0) {
                contador = 2;
            }

            for (int j = 0; j < contador; j++) {
                System.out.print(musica[j] + " ");
            }
            if (contador == 2)
                contador = 3;
            if (contador == 7)
                contador = 8;
            if (contador == 9)
                contador = 10;

            contador++;
            System.out.println();
        }

        contador = 11;

        for (int i = 0; i < 7; i++) {

            if (contador == 3)
                contador = 2;

            for (int j = 0; j < contador; j++) {
                System.out.print(musica[j] + " ");
            }

            if (contador == 11)
                contador = 10;
            if (contador == 9)
                contador = 8;

            contador--;
            System.out.println();
        }


    }

    public static void main(String[] args) {

        String musica = "Yeah eu te amo muito mas agora é tarde eu vou dormir";
        MameDAgua(musica);

    }
}
