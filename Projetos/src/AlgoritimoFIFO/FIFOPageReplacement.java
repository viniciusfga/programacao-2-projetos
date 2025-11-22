package AlgoritimoFIFO;

// ------------------------------------------------------------
// Algoritmo de Substituição de Páginas - FIFO
// Desenvolvido para atender às exigências do seminário de SO
// ------------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOPageReplacement {

    // ------------------------------------------------------------
    // Método principal: realiza leitura do arquivo e chama execução
    // ------------------------------------------------------------
    public static void main(String[] args) {
        String nomeArquivo = "./Projetos/src/AlgoritimoFIFO/entrada.txt";

        try {
            // Lê o arquivo e obtém quadros + sequência de páginas
            DadosEntrada dados = lerArquivo(nomeArquivo);

            int pageFaults = executarFIFO(dados.paginas, dados.quantidadePaginas, dados.qtdQuadros);

            System.out.println("Quantidade de Page Faults: " + pageFaults);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // Classe auxiliar para armazenar os dados lidos do arquivo
    // ------------------------------------------------------------
    static class DadosEntrada {
        int qtdQuadros;
        int[] paginas;
        int quantidadePaginas;

        DadosEntrada(int qtdQuadros, int[] paginas, int quantidadePaginas) {
            this.qtdQuadros = qtdQuadros;
            this.paginas = paginas;
            this.quantidadePaginas = quantidadePaginas;
        }
    }

    // ------------------------------------------------------------
    // Método para ler o arquivo .txt
    // ------------------------------------------------------------
    public static DadosEntrada lerArquivo(String nomeArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

        // Primeira linha - quantidade de quadros de memória
        int qtdQuadros = Integer.parseInt(br.readLine().trim());

        // As demais linhas - sequência de referências de páginas
        LinkedList<Integer> listaPaginas = new LinkedList<>();

        String linha;
        while ((linha = br.readLine()) != null) {
            if (!linha.trim().isEmpty()) {
                listaPaginas.add(Integer.parseInt(linha.trim()));
            }
        }

        br.close();

        // Converte lista para array
        int[] paginas = new int[listaPaginas.size()];
        for (int i = 0; i < listaPaginas.size(); i++) {
            paginas[i] = listaPaginas.get(i);
        }

        return new DadosEntrada(qtdQuadros, paginas, paginas.length);
    }

    // ------------------------------------------------------------
    // Executa o algoritmo FIFO e retorna o número de page faults
    // ------------------------------------------------------------
    public static int executarFIFO(int[] paginas, int n, int capacidade) {

        // Conjunto para representar os quadros de memória
        HashSet<Integer> memoria = new HashSet<>(capacidade);

        // Fila para manter a ordem FIFO (quem entrou primeiro sai primeiro)
        Queue<Integer> filaFIFO = new LinkedList<>();

        int pageFaults = 0;

        // Percorre todas as referências de páginas
        for (int i = 0; i < n; i++) {

            int paginaAtual = paginas[i];

            // Caso ainda haja espaço na memória
            if (memoria.size() < capacidade) {

                // Se a página NÃO estiver presente → page fault
                if (!memoria.contains(paginaAtual)) {
                    memoria.add(paginaAtual);
                    filaFIFO.add(paginaAtual);
                    pageFaults++;
                }

            } else {

                // Memória cheia → verificar se a página já existe
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
