package Iniciante;

import java.util.Scanner;

public class Bee_1020 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dias = sc.nextInt();

        int anos = dias / 365;
        int restoDias = dias % 365;

        int meses = restoDias / 30;
        dias = restoDias % 30;

        System.out.println(anos + " ano(s)");
        System.out.println(meses + " mes(es)");
        System.out.println(dias + " dia(s)");

        sc.close();
    }
}
