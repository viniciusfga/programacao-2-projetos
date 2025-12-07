package Recursividade;

/**
 * Classe para demonstrar ordem de chamadas recursivas entre dois métodos.
 * Aqui observamos:
 * - Recursão DIRETA em recuB (chama ele mesmo)
 * - Recursão INDIRETA em recuA (chama recuB, que é recursivo)
 * - Diferença na ordem de impressão antes/depois da chamada recursiva
 */
public class OrdemDeChamada {

    /**
     * Método recursivo direto.
     *
     * Características:
     * - A recursão acontece ao final da função (após print → chamada recursiva)
     * - Isso caracteriza uma RECUSÃO EM CAUDA (tail recursion)
     *
     * Fluxo:
     * n = 1 → imprime 1 → chama recuB(2)
     * n = 2 → imprime 2 → chama recuB(3)
     * ...
     *
     * @param n valor inicial da recursão
     */
    public static void recuB(int n) {
        if (n < 5) {
            System.out.println(n);
            recuB(n + 1); // chamada recursiva direta
        }
    }

    /**
     * Método com recursão indireta.
     *
     * Características:
     * - Não é recursão direta, pois ele NÃO chama recuA.
     * - Ele chama recuB, que é o método recursivo. Portanto é RECUSÃO INDIRETA.
     * - A chamada recursiva ocorre ANTES do println, então a ordem final fica invertida.
     *
     * Fluxo:
     * Para n=1:
     *   recuB(2) roda completamente imprimindo 2,3,4
     *   depois imprime 1
     *
     * Para n=2:
     *   recuB(3) roda imprimindo 3,4
     *   depois imprime 2
     *
     * ... até n=4
     *
     * @param n valor inicial da recursão
     */
    public static void recuA(int n) {
        if (n < 5) {
            recuB(n + 1);  // recursão indireta (chama método recursivo)
            System.out.println(n); // executado NA VOLTA da recursão
        }
    }

    /**
     * Método principal apenas demonstra a execução
     * da ordem de chamadas dos métodos recuA e recuB.
     */
    public static void main(String[] args) {

        int num = 1;

        System.out.println("RECURSÃO A");
        recuA(num);

        System.out.println("RECURSÃO B");
        recuB(num);
    }
}
