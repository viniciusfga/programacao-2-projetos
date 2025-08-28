package Iniciante;

import java.util.Scanner;

public class Bee_1019 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int horas, minutos, segundos;

        horas = N / 3600;
        minutos = N % 3600 / 60;
        segundos = N % 60;

        System.out.printf("%d:%d:%d%n", horas, minutos, segundos);

        sc.close();
    }
}
