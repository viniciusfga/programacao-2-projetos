package PROVA1.TCC;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class TCCs {

    public static class TCC {
        int numeroAvaliacao;
        String nome;
        String alunoA;
        String alunoB;
        String orientador;
        double nota;
        boolean defendido;
        boolean atrasado;
        boolean defesaAgendada;

        public TCC(int numeroAvaliacao, String nome, String alunoA, String alunoB, String orientador) {
            this.numeroAvaliacao = numeroAvaliacao;
            this.nome = nome;
            this.alunoA = alunoA;
            this.alunoB = alunoB;
            this.orientador = orientador;
            this.nota = 0;
            this.defendido = false;
            this.atrasado = false;
            this.defesaAgendada = false;
        }
    }

    private final List<TCC> listaTCCs;

    public TCCs() {
        listaTCCs = new ArrayList<>();
    }

    // Cadastrar um novo TCC
    public void cadastrarTCC(int numeroAvaliacao, String nome, String alunoA, String alunoB, String orientador) {
        if (listaTCCs.size() >= 5) {
            System.out.println("Limite de 5 TCCs atingido!");
            return;
        }
        listaTCCs.add(new TCC(numeroAvaliacao, nome, alunoA, alunoB, orientador));
        System.out.println("TCC cadastrado!");
    }

    // Alterar TCC existente
    public void alterarTCC(int numeroAvaliacao, String nome, String alunoA, String alunoB, String orientador) {
        TCC tcc = buscarTCC(numeroAvaliacao);
        if (tcc != null) {
            tcc.nome = nome;
            tcc.alunoA = alunoA;
            tcc.alunoB = alunoB;
            tcc.orientador = orientador;
            System.out.println("TCC alterado!");
        } else {
            System.out.println("TCC não encontrado!");
        }
    }

    // Excluir TCC
    public void excluirTCC(int numeroAvaliacao) {
        TCC tcc = buscarTCC(numeroAvaliacao);
        if (tcc != null) {
            listaTCCs.remove(tcc);
            System.out.println("TCC excluído!");
        } else {
            System.out.println("TCC não encontrado!");
        }
    }

    // Listar TCCs
    public void listarTCCs() {
        if (listaTCCs.isEmpty()) {
            System.out.println("Nenhum TCC cadastrado.");
            return;
        }

        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-6s %-10s %-10s %-10s\n",
                "Aval", "Nome TCC", "Aluno A", "Aluno B", "Orientador", "Nota", "Defendido", "Atrasado", "Agendado");
        for (TCC t : listaTCCs) {
            System.out.printf("%-5d %-20s %-15s %-15s %-15s %-6.2f %-10s %-10s %-10s\n",
                    t.numeroAvaliacao, t.nome, t.alunoA, t.alunoB, t.orientador, t.nota,
                    t.defendido, t.atrasado, t.defesaAgendada);
        }
    }

    // Ver estatísticas
    public void verEstatisticas() {
        int total = listaTCCs.size();
        if (total == 0) {
            System.out.println("Nenhum TCC cadastrado.");
            return;
        }

        long atrasados = listaTCCs.stream().filter(t -> t.atrasado).count();
        long defendidos = listaTCCs.stream().filter(t -> t.defendido).count();
        long agendados = listaTCCs.stream().filter(t -> t.defesaAgendada).count();

        System.out.printf("Percentual de TCCs atrasados: %.2f%%\n", (atrasados * 100.0 / total));
        System.out.printf("Percentual de TCCs defendidos: %.2f%%\n", (defendidos * 100.0 / total));
        System.out.printf("Percentual de TCCs com defesa agendada: %.2f%%\n", (agendados * 100.0 / total));

        // Quantidade de TCC por orientador
        Map<String, Integer> contagemOrientador = new HashMap<>();
        for (TCC t : listaTCCs) {
            contagemOrientador.put(t.orientador, contagemOrientador.getOrDefault(t.orientador, 0) + 1);
        }
        System.out.println("Quantidade de TCCs por orientador:");
        contagemOrientador.forEach((prof, qtd) -> System.out.println(prof + ": " + qtd));

        // TCC com maior nota
        TCC maiorNota = listaTCCs.stream().max((t1, t2) -> Double.compare(t1.nota, t2.nota)).orElse(null);
        if (maiorNota != null) {
            System.out.println("TCC com maior nota: " + maiorNota.nome + " (" + maiorNota.nota + ")");
        }
    }

    // Buscar TCC por número de avaliação
    private TCC buscarTCC(int numeroAvaliacao) {
        return listaTCCs.stream()
                .filter(t -> t.numeroAvaliacao == numeroAvaliacao)
                .findFirst()
                .orElse(null);
    }
}
