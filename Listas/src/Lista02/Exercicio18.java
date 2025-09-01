package Lista02;

import java.util.Scanner;

public class Exercicio18 {

    public static void compactarImagem(byte[][] m) {

        for (int i = 0; i < m.length; i++) {
            byte atual = m[i][0];
            int contador = 1;

            for (int j = 1; j < m[i].length; j++) {
                if (m[i][j] == atual) {
                    contador++;
                } else {
                    // imprime o bloco atual no formato certo
                    imprimirBloco(atual, contador);
                    atual = m[i][j];
                    contador = 1;
                }
            }
            // imprime último bloco da linha
            imprimirBloco(atual, contador);
        }
        System.out.println();
    }

    private static void imprimirBloco(byte valor, int qtd) {
        if (valor == 1) {
            System.out.printf("%dB", qtd);
        } else {
            System.out.printf("%dP", qtd);
        }
    }

    public static byte[][] descompactarImagem(String codico) {

        int length = Character.getNumericValue(codico.charAt(0));

        byte[][] imagem = new byte[length][length];

        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                for (int k = 0; k < codico.length(); k++) {
                    char caractere = codico.charAt(k);

                    if (Character.isDigit(caractere) && codico.charAt(k + 1) == 'P') {
                        imagem[i][j] = 0;
                    }
                    if (Character.isDigit(caractere) && codico.charAt(k + 1) == 'B') {
                        imagem[i][j] = 1;
                    }
                }
            }
        }

        return imagem;
    }

    public static void imprimirMatriz(byte[][] imagem) {

        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                System.out.printf("%4d", imagem[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha uma das opções: ");
        System.out.println(" 0 - COMPACTAR");
        System.out.println(" 1 - DESCOMPACTAR");
        int opcao = sc.nextByte();

        switch (opcao) {
            case 0:
                byte[][] imagem = {
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 0, 1, 0, 1},
                        {1, 0, 1, 0, 0, 1, 0, 1},
                        {0, 1, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 0, 0, 0, 1, 0},
                        {0, 0, 1, 1, 1, 1, 0, 0}
                };
                compactarImagem(imagem);
                break;
            case 1:
                String codicoImagem = sc.nextLine();
                int confirmar = 0;
                System.out.println("Digite 1 para confimar");
                confirmar = sc.nextInt();
                if (confirmar == 1) {
                    descompactarImagem(codicoImagem);
                }
                break;
        }
        sc.close();

    }
}
