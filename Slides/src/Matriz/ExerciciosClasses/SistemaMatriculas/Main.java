package Matriz.ExerciciosClasses.SistemaMatriculas;


public class Main {

    public static void main(String[] args) {

        Aluno a1 = new Aluno("Maria", "123");

        Disciplina ed = new Disciplina("Estruturas de Dados", "Seg 10h", 30);
        Disciplina poo = new Disciplina("POO", "Seg 10h", 30);

        // Definir pré-requisito
        poo.preRequisito = ed;

        // Tentar matricular em POO (sem ter feito ED)
        if (ValidadorMatricula.podeMatricular(a1, poo)) {
            poo.matricularAluno();
            a1.disciplinaMatriculada = poo;
            System.out.println("Matrícula em POO realizada!");
        } else {
            System.out.println("Não é possível matricular em POO.");
        }

        ed.matricularAluno();
        a1.disciplinaMatriculada = ed;

        if (ValidadorMatricula.podeMatricular(a1, poo)) {
            poo.matricularAluno();
            a1.disciplinaMatriculada = poo;
            System.out.println("Matrícula em POO realizada agora!");
        } else {
            System.out.println("Ainda não é possível matricular em POO.");
        }
    }
}
