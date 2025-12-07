package Lista01;

public class Exercicio15 {
    public static void main(String[] args) {

        System.out.println("Inverter uma string com laço for.");

        String palavra = "java";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            System.out.print(palavra.charAt(i));
        }
        

    }
}
