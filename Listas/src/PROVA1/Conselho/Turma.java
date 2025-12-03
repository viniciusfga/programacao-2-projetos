package PROVA1.Conselho;

import java.util.ArrayList;

public class Turma {
    private String nome;
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public Turma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public int contarProblemas(TipoProblema tipo) {
        int count = 0;
        for (Aluno a : alunos) {
            if (a.getProblema() == tipo) {
                count++;
            }
        }
        return count;
    }

    public double percentualProblema(TipoProblema tipo) {
        if (alunos.size() == 0) return 0;
        int qtd = contarProblemas(tipo);
        return (qtd * 100.0) / alunos.size();
    }

    @Override
    public String toString() {
        return "Turma: " + nome + " | Alunos cadastrados: " + alunos.size();
    }
}
