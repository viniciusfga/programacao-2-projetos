package HotelariaV1;

import java.util.Scanner;

public class Utils {

    private static Scanner sc = new Scanner(System.in);

    // Método para ler um número inteiro
    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        return Integer.parseInt(sc.nextLine());
    }

}
