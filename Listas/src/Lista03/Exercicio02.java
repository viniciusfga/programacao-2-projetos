package Lista03;

import java.util.Scanner;

public class Exercicio02 {
    /*
    Verifique se um endereço de email possui a forma correta
     */
    static void verificarEmail(String email) {
        if (email.contains(" ")) {
            System.out.println("Email inválido (contém espaço)");
            return;
        }

        int posArroba = email.indexOf('@');
        if (posArroba == -1 || posArroba != email.lastIndexOf('@')) {
            System.out.println("Email inválido (arroba ausente ou duplicada)");
            return;
        }

        String nome = email.substring(0, posArroba);
        String dominio = email.substring(posArroba + 1);

        if (nome.isEmpty() || dominio.isEmpty()) {
            System.out.println("Email inválido (faltando nome ou domínio)");
            return;
        }

        if (nome.startsWith(".") || nome.endsWith(".")) {
            System.out.println("Email inválido (nome inválido)");
            return;
        }

        if (!dominio.contains(".")) {
            System.out.println("Email inválido (domínio sem ponto)");
            return;
        }

        if (dominio.startsWith(".") || dominio.endsWith(".")) {
            System.out.println("Email inválido (domínio inválido)");
            return;
        }

        System.out.println("Email válido");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu email: ");
        String email = input.nextLine();

        verificarEmail(email);

    }
}
