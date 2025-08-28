package Iniciante;

import java.io.IOException;
import java.util.Scanner;

public class Bee_1047 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int horaInicial = sc.nextInt();
        int minutosInicial = sc.nextInt();
        int horaFinal = sc.nextInt();
        int minutoFinal = sc.nextInt();
        int horas, minutos;

        int inicio = horaInicial * 60 + minutosInicial;
        int fim = horaFinal * 60 + minutoFinal;

        int duracao = fim - inicio;
        if (duracao <= 0) {
            duracao += 1440;
        }

        horas = duracao / 60;
        minutos = duracao % 60;

        System.out.println("O JOGO DUROU " + horas + " HORA(S) E " + minutos + " MINUTO(S)");

    }
}
