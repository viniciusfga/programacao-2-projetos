package REVISAO;

import java.util.Scanner;

public class Exercicio04 {
    /*
    O teto do salão é formado por segmentos de reta.

    - Se um balão tocar um segmento horizontal, ele fica preso.
    - Se tocar um segmento inclinado, ele desliza até o ponto mais alto e pode escapar ou tocar em outros segmentos.
    - Os segmentos não se intersectam.
    Dada a descrição do teto e a posição em que o balão é solto no piso ((X, 0)), determine se ele:
    - Escapa do salão → imprimir apenas a coordenada X de saída.
    - Fica preso no teto → imprimir as coordenadas (X, Y) do ponto onde fica retido.
    Entrada:
        A primeira linha contém dois inteiros N e C, o número de segmentos e de consultas.
        As próximas N linhas contêm quatro inteiros X1 Y1 X2 Y2, definindo cada segmento.
        As próximas C linhas contêm um inteiro X, a posição inicial do balão.

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // número de segmentos
        int C = sc.nextInt(); // número de consultas

        // armazenar os segmentos em vetores
        int[] x1 = new int[N];
        int[] y1 = new int[N];
        int[] x2 = new int[N];
        int[] y2 = new int[N];

        for (int i = 0; i < N; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }

        // processar cada balão
        for (int c = 0; c < C; c++) {
            int x = sc.nextInt();
            int y = 0;

            while (true) {
                int menorAltura = Integer.MAX_VALUE;
                int indice = -1;

                // verificar em qual segmento o balão bate
                for (int i = 0; i < N; i++) {
                    if (x >= Math.min(x1[i], x2[i]) && x <= Math.max(x1[i], x2[i])) {
                        // calcular altura do segmento no ponto x
                        double m = (double) (y2[i] - y1[i]) / (x2[i] - x1[i]);
                        double altura = y1[i] + m * (x - x1[i]);

                        if (altura > y && altura < menorAltura) {
                            menorAltura = (int) altura;
                            indice = i;
                        }
                    }
                }

                if (indice == -1) {
                    // não bateu em nenhum segmento - escapa
                    System.out.println(x);
                    break;
                }

                if (y1[indice] == y2[indice]) {
                    // segmento horizontal → preso
                    System.out.println(x + " " + menorAltura);
                    break;
                } else {
                    // segmento inclinado → desliza para o ponto mais alto
                    if (y1[indice] > y2[indice]) {
                        x = x1[indice];
                        y = y1[indice];
                    } else {
                        x = x2[indice];
                        y = y2[indice];
                    }
                }
            }
        }

        sc.close();
    }
}
