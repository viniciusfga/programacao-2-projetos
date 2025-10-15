package PROVA01.Conselho;

public class Aluno {
    private String nome;
    private TipoProblema problema;

    public Aluno(String nome, TipoProblema problema) {
        this.nome = nome;
        this.problema = problema;
    }

    public String getNome() {
        return nome;
    }

    public TipoProblema getProblema() {
        return problema;
    }

    public String toString() {
        return nome + " - Problema: " + problema;
    }
}
