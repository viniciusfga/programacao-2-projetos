package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Criptografia simples rotacionando letras.");

        System.out.print("Digite a mensagem: ");
        String mensagem = sc.nextLine();

        System.out.print("Digite o deslocamento (shift): ");
        int shift = sc.nextInt();

        String resultado = "";

        for (int i = 0; i < mensagem.length(); i++) {
            char c = mensagem.charAt(i);

            if (Character.isUpperCase(c)) {
                resultado += (char) ((('A' - shift + 26) % 26) + 'A');
            } else if (Character.isLowerCase(c)) {
                resultado += (char) ((('a' - shift + 26) % 26) + 'a');
            } else{
                resultado += c;
            }
        }

        System.out.println("Mensagem criptografada: " + resultado);
        sc.close();

    }
}
