package REVISAO_3;

public class MatrizFinanceira {

    private double[][] despesas;
    private double[][] receitas;

    String[] MESES = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };

    public MatrizFinanceira() {
        despesas = new double[12][4];
        receitas = new double[12][4];
    }

    static boolean validar(int mes, int semana) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("ERRO: Mês ou semana inválido ");
            return false;
        }
        return true;
    }

    public void atualizar(double[][] matriz, int mes, int semana, double valor, String operacao) {
        if (!validar(mes, semana)) return;

        switch (operacao) {
            case "Cadastrar" -> despesas[mes - 1][semana - 1] += valor;
            case "Alterar" -> despesas[mes - 1][semana - 1] = valor;
            case "Excluir" -> despesas[mes - 1][semana - 1] = 0;
            default -> System.out.println("ERRO: Operação inválida");
        }
    }

    // ---------------- Despesas ----------------
    public void cadastrarDespesas(int mes, int semana, double valor) {
        atualizar(despesas, mes, semana, valor, "Cadastrar");
    }

    public void alterarDespesas(int mes, int semana, double valor) {
        atualizar(despesas, mes, semana, valor, "Alterar");
    }

    public void excluirDespesas(int mes, int semana) {
        atualizar(despesas, mes, semana, 0, "Excluir");
    }

    // ---------------- Receitas ----------------
    public void cadastrarReceitas(int mes, int semana, double valor) {
        atualizar(receitas, mes, semana, valor, "Cadastrar");
    }

    public void alterarReceitas(int mes, int semana, double valor) {
        atualizar(receitas, mes, semana, valor, "Alterar");
    }

    public void excluirReceitas(int mes, int semana) {
        atualizar(receitas, mes, semana, 0, "Excluir");
    }

    // ---------------- Estatisticas ----------------
    public void verEstatisticas() {

        System.out.println("------- DESPESAS & RECEITAS -------");

        for (int i = 0; i < 12; i++) {
            double somaDespesas = 0, somaReceitas = 0;

            for (int j = 0; j < 4; j++) {
                somaDespesas += despesas[i][j];
                somaReceitas += receitas[i][j];
            }
            double saldo = somaDespesas - somaReceitas;
            System.out.printf("%s --> Receitas %2.f | Despesas %2.f | Saldo %2.f%n",
                    MESES[i], somaDespesas, somaReceitas, saldo);
        }
    }

    // ---------------- Listas Meses ----------------
    public void listarMeses() {

        for (int i = 0; i < 12; i++) {
            System.out.println((i -1) + " - " + MESES[i]);
        }
    }

}
