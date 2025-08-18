import java.util.Scanner;

public class Exercicio_333 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double pi = 4 , anterior = 0.0 , somatorio = 0.0 , denominadorP = 1, denominadorN = 3, diferenca = 0.00000000005;

        boolean loop = true;

        while (loop) {

            // SUM  POSITIVE 1 - 1/5 - 1/9 - 1/13
            somatorio += ( 1 / denominadorP);
            denominadorP += 4;
            // SUM NEGATIVE 1/3 - 1/7 - 1/11
            somatorio -= ( 1 / denominadorN);
            denominadorN += 4;

            anterior = pi;
            pi *= somatorio;

            if ( (pi - anterior) <= diferenca) {
                loop = false;
            }
            System.out.println("Valor aproximado:   " + pi);

        }

    }
}
