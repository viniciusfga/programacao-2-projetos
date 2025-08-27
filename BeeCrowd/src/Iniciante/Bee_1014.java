package Iniciante;

import java.util.Scanner;

public class Bee_1014 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int distancia = sc.nextInt();
        double combustivel = sc.nextDouble();

        double consumo = distancia / combustivel;

        System.out.printf("%.3f%n km/l%n", consumo);

        sc.close();
    }
}
