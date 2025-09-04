package Iniciante;

import java.util.Arrays;
import java.util.Scanner;

public class Bee_1042 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] numeros = {a, b, c};
        Arrays.sort(numeros);

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        System.out.println();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        sc.close();

    }
}
