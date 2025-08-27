package Iniciante;

import java.util.Scanner;

public class Bee_1016 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int distancia = sc.nextInt();

        int tempo = distancia * 2;

        System.out.println(tempo + " minutos");

        sc.close();
    }
}
