package HotelariaPOO.utils;

import java.util.Scanner;

public class Utils {

    private static Scanner sc = new Scanner(System.in);

    // Método para ler um texto
    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    // Método para ler um número inteiro
    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        return Integer.parseInt(sc.nextLine());
    }

    // Método para ler um número decimal
    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        return Double.parseDouble(sc.nextLine());
    }

    // Método para formatar valores monetários
    public static String formatarMoeda(double valor) {
        return String.format("R$ %.2f", valor);
    }

    // Método para validar um CPF simples (tamanho)
    public static boolean validarCpf(String cpf) {
        return cpf != null && cpf.replaceAll("[^0-9]", "").length() == 11;
    }

    // Método para pausar a execução (aguardar Enter)
    public static void pausar() {
        System.out.println("\nPressione Enter para continuar...");
        sc.nextLine();
    }
}
