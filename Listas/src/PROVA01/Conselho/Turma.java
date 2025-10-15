package PROVA01.Conselho;

import java.util.ArrayList;

public class Turma {
    private String nome;
    private ArrayList<Aluno> alunos;

    public Turma(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public Turma() {
        this.alunos = new ArrayList<>();
    }

    // === Métodos básicos ===
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    // Adiciona um aluno à turma
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // Mostra todos os alunos cadastrados
    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado nesta turma.");
        } else {
            System.out.println("\n--- Alunos da Turma " + nome + " ---");
            for (Aluno a : alunos) {
                System.out.println("- " + a.getNome() + " (" + a.getProblema() + ")");
            }
        }
    }

    // Calcula total de alunos com cada tipo de problema
    public void estatisticas() {
        if (alunos.isEmpty()) {
            System.out.println("Sem alunos para calcular estatísticas.");
            return;
        }

        int total = alunos.size();
        int disciplina = 0, rendimento = 0, faltas = 0, outros = 0;

        for (Aluno a : alunos) {
            switch (a.getProblema()) {
                case DISCIPLINAR -> disciplina++;
                case BAIXO_RENDIMENTO -> rendimento++;
                case FALTAS_EXCESSIVAS -> faltas++;
                case OUTROS -> outros++;
            }
        }

        System.out.println("\n=== Estatísticas da Turma " + nome + " ===");
        System.out.printf("Disciplinar: %.2f%%\n", (disciplina * 100.0 / total));
        System.out.printf("Baixo rendimento: %.2f%%\n", (rendimento * 100.0 / total));
        System.out.printf("Faltas excessivas: %.2f%%\n", (faltas * 100.0 / total));
        System.out.printf("Outros: %.2f%%\n", (outros * 100.0 / total));
    }
}
