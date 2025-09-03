package Lista02;

import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();

        String[] palavras = frase.split("\\s+"); // separa por espaço

        System.out.println("Palavras que começam com vogal:");
        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                char primeira = Character.toLowerCase(palavra.charAt(0));
                if ("aeiou".indexOf(primeira) != -1) {
                    System.out.println(palavra);
                }
            }
        }

        sc.close();
    }
}
