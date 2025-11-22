package AlgoritimoFIFO;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Light {

    public static void main(String[] args) {

        // ------------------------------
        // Entrada simulada (SEM ARQUIVO)
        // ------------------------------
        int qtdFrames = 3;  // quantidade de quadros de memória

        int[] paginas = {7, 0, 1, 2, 0, 3, 0, 4};
        int quantidadePaginas = paginas.length;

        // Executa o algoritmo FIFO
        int pageFaults = executarFIFO(paginas, quantidadePaginas, qtdFrames);

        System.out.println("Quantidade de Page Faults: " + pageFaults);
    }


    // ------------------------------------------------------
    // Função que executa o algoritmo FIFO de paginação
    // ------------------------------------------------------
    public static int executarFIFO(int[] paginas, int n, int capacidade) {

        // Conjunto representando os quadros da memória
        HashSet<Integer> memoria = new HashSet<>(capacidade);

        // Fila que define a ordem FIFO
        Queue<Integer> filaFIFO = new LinkedList<>();

        int pageFaults = 0;

        // Percorre todas as páginas solicitadas
        for (int i = 0; i < n; i++) {

            int paginaAtual = paginas[i];

            // Caso ainda exista espaço livre nos quadros
            if (memoria.size() < capacidade) {

                // Se página não está na memória → page fault
                if (!memoria.contains(paginaAtual)) {
                    memoria.add(paginaAtual);
                    filaFIFO.add(paginaAtual);
                    pageFaults++;
                }

            } else { // Memória cheia

                // Se a página não está na memória → substituir
                if (!memoria.contains(paginaAtual)) {

                    // Remove a página mais antiga (FIFO)
                    int paginaRemovida = filaFIFO.poll();
                    memoria.remove(paginaRemovida);

                    // Adiciona a nova página
                    memoria.add(paginaAtual);
                    filaFIFO.add(paginaAtual);

                    pageFaults++;
                }
            }
        }

        return pageFaults;
    }
}
