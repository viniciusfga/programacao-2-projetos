package Iniciante;

import java.util.Scanner;

public class Bee_1011 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double R = sc.nextDouble();

        double volume = (4 * 3.14159 * R * R * R) / 3;

        System.out.printf("VOLUME = %.3f%n", volume);

        sc.close();
    }
}
