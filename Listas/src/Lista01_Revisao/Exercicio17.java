package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Criar laço que pare ao digitar \"sair\".");

        String resposta = "";

        while (!"sair".equals(resposta)){
            resposta = sc.nextLine();
        }

        System.out.println("Programa encerrado!");
        sc.close();

    }
}
