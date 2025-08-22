package Mes01;

import java.util.Scanner;

public class Exercicio_Treino1_V1 {
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

        String Str = String.valueOf(N);
        int[] vet;
        vet = new int[Str.length()];

        for (int i = 0; i < Str.length(); i++) {
            char digito = Str.charAt(i);
            vet[i] = digito - '0';
            System.out.println(vet[i]);
        }

        if (N < 10) {
            System.out.println(unidades[N]);
        }
        else if (N < 20) {
            System.out.println(dezenasDez[N - 10]);
        }
        else if (N < 100) {
            System.out.println(dezenas[vet[0]] + " " + unidades[vet[1]]);
        }
        else if (N < 1000) {
            System.out.println(centenas[vet[0]] +" e " + dezenas[vet[1] - 1] + " " + unidades[vet[2]]);
        }
        else if (N < 10000) {
            System.out.println(unidades[vet[0]] + " mil " + centenas[vet[1] - 1] + " e " + dezenas[vet[2] - 1] + " " + unidades[vet[3]]);
        }

    }
}
