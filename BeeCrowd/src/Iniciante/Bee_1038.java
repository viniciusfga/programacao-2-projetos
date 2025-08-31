package Iniciante;

import java.io.IOException;
import java.util.Scanner;

public class Bee_1038 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        double cachorro = 4.0;
        double salada = 4.50;
        double bacon = 5.0;
        double torrada = 2.0;
        double refri = 1.5;

        int codigo = sc.nextInt();
        int quantidade = sc.nextInt();

        double valor = 0.0;

        switch (codigo) {
            case 1:
                valor = cachorro * quantidade;
                break;
            case 2:
                valor = salada * quantidade;
                break;
            case 3:
                valor = bacon * quantidade;
                break;
            case 4:
                valor = torrada * quantidade;
                break;
            case 5:
                valor = refri * quantidade;
                break;
            default:
                System.out.println("Código inválido!");
                sc.close();
                return;
        }

        System.out.printf("Total: R$ %.2f%n", valor);
        sc.close();

    }
}
