package Iniciante;

import java.util.Scanner;

public class Bee_1017 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tempoGasto = sc.nextInt();
        int velocidadeMedia = sc.nextInt();

        double litros = (double) ( tempoGasto * velocidadeMedia) / 12;

        System.out.printf("%.3f%n", litros);

        sc.close();
    }
}
