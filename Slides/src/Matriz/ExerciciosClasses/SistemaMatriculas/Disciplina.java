package Matriz.ExerciciosClasses.SistemaMatriculas;

public class Disciplina {
    String nome;
    String horario;
    int vagas;
    Disciplina preRequisito;
    int alunosMatriculados = 0;

    public Disciplina(String nome, String horario, int vagas) {
        this.nome = nome;
        this.horario = horario;
        this.vagas = vagas;
    }

    public boolean temVaga() {
        return alunosMatriculados < vagas;
    }

    public void matricularAluno() {
        alunosMatriculados++;
    }
}
