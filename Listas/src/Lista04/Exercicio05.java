package Lista04;

public class Exercicio05 {

    public static int mdc(int a, int b) {

        // Não existe MDC para zero
        if (a == 0 || b == 0) throw new IllegalArgumentException("0 não tem divisor");

        // Garante que 'a' seja o maior número
        if (b > a){
            int temp = a;
            a = b;
            b = temp;
        }

        // Calcula o resto da divisão
        int resto = a % b;
        // Caso base: se não há resto, b é o MDC
        if (a % b == 0) return b;
        // Chamada recursiva com os novos valores
        return mdc(resto, b);
    }

    public static void main(String[] args) {

        try{
            int a = 18;
            int b = 12;
            int mds = mdc(a, b);
            System.out.println(mds);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
