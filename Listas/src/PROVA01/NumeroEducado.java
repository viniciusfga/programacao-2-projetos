package PROVA01;

import java.util.InputMismatchException;
import java.util.Scanner;

class NumeroEducado {

    public static String verificaNumeroEducado (int numero){
        for (int start = 1; start < numero ; start++) {
            int soma = 0;
            for (int i = start; soma < numero; i++) {
                soma += i;
            }
            if (soma == numero) {
                return "Educado";
            }
        }
        
        return "Mal Educado";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = 0;
        
        try {
            System.out.println("Digite um número para verificar se ele é educado ou não");
            numero = sc.nextInt();
            if (numero <= 0) {
                System.out.println("Digite apenas números inteiros positivos.");
                return;
            }
        } catch (InputMismatchException e){
            System.out.println("ERRO: Digite um número");
        }

        String resultado = verificaNumeroEducado(numero);
        System.out.println(numero + " é " + resultado + "!");

    }
}
