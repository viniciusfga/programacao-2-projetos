package Mes01;

import java.util.Scanner;

public class Exercicio01_Treino_V2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Elaborar um programa que permita a entrada de um número inteiro entre 1 e 9999 e o escreva por extenso");

        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
        String[] dezenasDez = {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
        String[] centenas = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

        System.out.println("Digite um número inteiro entre 1 e 9999:");
        int N = sc.nextInt();

        if (N < 1 || N > 9999) {
            System.out.println("Número fora do intervalo permitido!");
            sc.close();
            return;
        }

        String extenso = "";

        if ( N < 10) {
            extenso = unidades[N];
        } else if ( N < 20) {
            extenso = dezenasDez[N - 10];
        } else if ( N < 100 ) {
            extenso = dezenas[N];
        }


        System.out.println("Por extenso: " + extenso);
        sc.close();
    }
}
