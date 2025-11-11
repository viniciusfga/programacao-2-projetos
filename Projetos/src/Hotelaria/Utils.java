package Hotelaria;

import java.util.Scanner;

public class Utils {

    private static final Scanner sc = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }
}
