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

    public static byte[][] descompactarImagem(String codigo, int n) {
        byte[][] imagem = new byte[n][n];
        int linha = 0, coluna = 0;
        int i = 0;

        while (i < codigo.length()) {
            // pega número (pode ser >9)
            StringBuilder sb = new StringBuilder();
            while (i < codigo.length() && Character.isDigit(codigo.charAt(i))) {
                sb.append(codigo.charAt(i));
                i++;
            }
            int qtd = Integer.parseInt(sb.toString());

            // pega tipo (P=0, B=1)
            char tipo = codigo.charAt(i);
            i++;

            byte valor = (tipo == 'P') ? (byte) 0 : (byte) 1;

            for (int k = 0; k < qtd; k++) {
                imagem[linha][coluna] = valor;
                coluna++;
                if (coluna == n) {
                    coluna = 0;
                    linha++;
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
        int opcao = sc.nextInt();
        sc.nextLine();

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
                System.out.print("Digite o código compactado: ");
                String codigoImagem = sc.nextLine();
                System.out.print("Digite o tamanho da matriz (ex: 8): ");
                int tamanho = sc.nextInt();

                byte[][] imagemDecodificada = descompactarImagem(codigoImagem, tamanho);
                imprimirMatriz(imagemDecodificada);
                break;
        }
        sc.close();
    }
}