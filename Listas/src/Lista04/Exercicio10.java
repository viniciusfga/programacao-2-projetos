package Lista04;

public class Exercicio10 {

    public static void hanoi(int n, char origem, char destino, char auxiliar) {

        if (n <= 0) {
            throw new IllegalArgumentException("O número de discos deve ser maior que zero.");
        }

        // Caso base: mover apenas 1 disco
        if (n == 1) {
            System.out.println("Mover disco de " + origem + " para " + destino);
            return;
        }

        // Passo 1: mover n-1 discos da origem para a torre auxiliar
        hanoi(n - 1, origem, auxiliar, destino);

        // Passo 2: mover o disco restante da origem para o destino
        System.out.println("Mover disco de " + origem + " para " + destino);

        // Passo 3: mover os n-1 discos da torre auxiliar para o destino
        hanoi(n - 1, auxiliar, destino, origem);
    }


    public static void main(String[] args) {

        try {
            int discos = 3;

            hanoi(discos, 'A', 'C', 'B');

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
