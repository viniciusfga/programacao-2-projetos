package ExerciciosClasses.SistemaMatriculas;

public class ValidadorMatricula {
    public static boolean podeMatricular(Aluno aluno, Disciplina disciplina) {
        // 1. Pré-requisito: se disciplina tem pré-requisito e aluno não está nela
        if (disciplina.preRequisito != null) {
            if (aluno.disciplinaMatriculada != disciplina.preRequisito) {
                return false;
            }
        }

        // 2. Conflito de horário: se já tem disciplina com mesmo horário
        if (aluno.disciplinaMatriculada != null) {
            if (aluno.disciplinaMatriculada.horario.equals(disciplina.horario)) {
                return false;
            }
        }

        // 3. Vagas
        if (!disciplina.temVaga()) {
            return false;
        }

        return true;
    }
}


