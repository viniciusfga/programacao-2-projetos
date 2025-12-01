package PROVA1.Conselho;

import java.util.ArrayList;

public class Professor {
    private ArrayList<Turma> turmas = new ArrayList<>();

    public Turma buscarOuCriarTurma(String nome) {
        for (Turma t : turmas) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        Turma nova = new Turma(nome);
        turmas.add(nova);
        return nova;
    }

    public void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        for (Turma t : turmas) {
            System.out.println("\n" + t);
            if (t.getAlunos().isEmpty()) {
                System.out.println(" - Nenhum aluno com problemas.");
            } else {
                for (Aluno a : t.getAlunos()) {
                    System.out.println(" - " + a);
                }
            }
        }
    }

    public void exibirEstatisticas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        int totalAlunos = 0;
        for (Turma t : turmas) {
            totalAlunos += t.getAlunos().size();
        }

        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n===== ESTATÍSTICAS GERAIS =====");
        for (TipoProblema tipo : TipoProblema.values()) {
            int totalTipo = 0;
            for (Turma t : turmas) {
                totalTipo += t.contarProblemas(tipo);
            }

            double percGlobal = (totalTipo * 100.0) / totalAlunos;
            System.out.printf("%s: %.2f%% (%d alunos)\n", tipo, percGlobal, totalTipo);
        }

        Turma turmaMaisProblemas = null;
        int maxProblemas = 0;

        for (Turma t : turmas) {
            int qtd = t.getAlunos().size();
            if (qtd > maxProblemas) {
                maxProblemas = qtd;
                turmaMaisProblemas = t;
            }
        }

        if (turmaMaisProblemas != null) {
            System.out.println("Turma com mais problemas: " + turmaMaisProblemas.getNome() +
                    " (" + maxProblemas + " alunos)");
        }
    }
}
