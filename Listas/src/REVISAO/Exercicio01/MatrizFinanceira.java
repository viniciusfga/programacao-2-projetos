package REVISAO.Exercicio01;

public class MatrizFinanceira {

    private double[][] despesas;
    private double[][] receitas;

    String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };

    public MatrizFinanceira() {
        despesas = new double[12][4];
        receitas = new double[12][4];
    }

    public void cadastrarDespesas(int mes, int semana, double valor) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("Erro: mês ou semana inválida");
            return;
        }
        despesas[mes - 1][semana - 1] += valor; // acumula
    }

    public void alterarDespesas(int mes, int semana, double valor) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("Erro: mês ou semana inválida");
            return;
        }
        despesas[mes - 1][semana - 1] = valor; // substitui
    }

    public void excluirDespesas(int mes, int semana) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("Erro: mês ou semana inválida");
            return;
        }
        despesas[mes - 1][semana - 1] = 0;
    }

    public void cadastrarReceitas(int mes, int semana, double valor) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("Erro: mês ou semana inválida");
            return;
        }
        receitas[mes - 1][semana - 1] += valor; // acumula
    }

    public void alterarReceitas(int mes, int semana, double valor) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("Erro: mês ou semana inválida");
            return;
        }
        receitas[mes - 1][semana - 1] = valor; // substitui
    }

    public void excluirReceitas(int mes, int semana) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("Erro: mês ou semana inválida");
            return;
        }
        receitas[mes - 1][semana - 1] = 0;
    }

    public void verEstatisticas() {
        double[] receitasTotal = new double[12];
        double[] despesasTotal = new double[12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                receitasTotal[i] += receitas[i][j]; // corrigido
                despesasTotal[i] += despesas[i][j];
            }
        }

        for (int i = 0; i < 12; i++) {
            System.out.println((i + 1) + " - " + meses[i]);
            System.out.println("   Receitas: " + receitasTotal[i]);
            System.out.println("   Despesas: " + despesasTotal[i]);
            System.out.println("   Saldo: " + (receitasTotal[i] - despesasTotal[i]));
            System.out.println("----------------------");
        }
    }

    public void listarMeses() {
        for (int i = 0; i < 12; i++) {
            System.out.println((i + 1) + " - " + meses[i]);
        }
    }
}
