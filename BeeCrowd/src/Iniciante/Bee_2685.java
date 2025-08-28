package Iniciante;

import java.io.IOException;
import java.util.Scanner;

public class Bee_2685 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            int inclinacao = sc.nextInt();

            inclinacao = inclinacao % 360;

            if (inclinacao >= 0 && inclinacao < 90) {
                System.out.println("Bom Dia!!");
            } else if (inclinacao >= 90 && inclinacao < 180) {
                System.out.println("Boa Tarde!!");
            } else if (inclinacao >= 180 && inclinacao < 270) {
                System.out.println("Boa Noite!!");
            } else {
                System.out.println("De Madrugada!!");
            }
        }
        sc.close();

    }
}
