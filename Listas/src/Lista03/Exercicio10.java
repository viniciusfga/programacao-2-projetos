package Lista03;

import java.util.Scanner;

public class Exercicio10 {
    /*
    Simule um estacionamento de trens usando um único trilho (vetor) para entrada e saída.
    Cada trem é identificado por um número inteiro.

    O usuário informa, a cada operação, se um trem está chegando ou se deseja remover um trem específico.
    Para remover um trem que não está no topo, use um vetor temporário para manobrar os trens à frente.
    Trate limites de capacidade e saídas inválidas. Ao final de cada operação, mostre o estado do trilho.
    */
    static int adicionarTrem(int[] principal, int topo, Scanner sc) {
        System.out.print("Número do trem: ");
        int trem = sc.nextInt();
        if (topo < principal.length - 1) {
            topo++;
            principal[topo] = trem;
            System.out.println("Trem " + trem + " entrou no trilho.");
        } else {
            System.out.println("Trilho cheio! Não é possível entrar.");
        }
        return topo; // devolve o topo atualizado
    }

    // lista trens
    static void listarTrem(int[] principal, int topo) {
        System.out.println("Trilho atual:");
        if (topo < 0) {
            System.out.println("(vazio)");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println("[" + principal[i] + "]");
            }
        }
    }

    // remove trem específico e devolve novo topo
    static int removerTrem(int[] principal, int topo, Scanner sc) {
        if (topo < 0) {
            System.out.println("Não há trens no trilho.");
            return topo;
        }

        System.out.print("Número do trem que deseja remover: ");
        int tremRemover = sc.nextInt();

        int[] temporario = new int[principal.length];
        int topoTemp = -1;
        boolean encontrado = false;

        // move trens até encontrar o desejado
        while (topo >= 0) {
            if (principal[topo] == tremRemover) {
                topo--;
                encontrado = true;
                System.out.println("Trem " + tremRemover + " saiu do trilho.");
                break;
            } else {
                topoTemp++;
                temporario[topoTemp] = principal[topo];
                topo--;
            }
        }

        if (!encontrado) {
            System.out.println("Trem " + tremRemover + " não encontrado.");
        }

        // devolve trens do temporário ao principal
        while (topoTemp >= 0) {
            topo++;
            principal[topo] = temporario[topoTemp];
            topoTemp--;
        }

        return topo; // devolve novo topo
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a capacidade de trens: ");
        int capacidade = sc.nextInt();
        int[] trilhoPrincipal = new int[capacidade];
        int topo = -1;

        while (true) {
            System.out.println("\n1 - Chegada de trem");
            System.out.println("2 - Saída de trem (informar número)");
            System.out.println("3 - Mostrar trilho");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    topo = adicionarTrem(trilhoPrincipal, topo, sc);
                    break;
                case 2:
                    topo = removerTrem(trilhoPrincipal, topo, sc);
                    break;
                case 3:
                    listarTrem(trilhoPrincipal, topo);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
