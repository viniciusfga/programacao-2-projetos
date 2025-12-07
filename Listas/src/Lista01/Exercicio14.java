package Lista01;

public class Exercicio14 {
    public static void main(String[] args) {

        System.out.println("Imprimir todos os primos de 1 a 1000.");

        for (int i = 3; i <= 1000; i += 2 ) {
            boolean primo = true;
            for (int j = 3; j * j <= i; j += 2) {
                if (i % j == 0) {
                    primo = false;
                    break;
                }
            }
            if(primo){
                System.out.println(i);
            }

        }


    }
}
