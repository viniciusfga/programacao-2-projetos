package REVISAO_2;

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

    private boolean validar(int mes, int semana) {
        if (mes < 1 || mes > 12 || semana < 1 || semana > 4) {
            System.out.println("Erro : mês ou semana inválida");
            return false;
        }
        return true;
    }

    public void atualizar(double[][] matriz, int mes, int semana, double valor, String operacao) {
        if (!validar(mes, semana)) return;

        switch (operacao) {
            case "cadastrar" -> despesas[mes - 1][semana - 1] += valor;
            case "alterar" -> despesas[mes - 1][semana - 1] = valor;
            case "excluir" ->despesas[mes - 1][semana - 1] = 0;
            default -> System.out.println("Erro: operacao invalida");
        }
    }


    // ---------------- Despesas ----------------
    public void cadastrarDespesa(int mes, int semana, double valor) {
        atualizar(despesas, mes, semana, valor, "cadastrar");
    }

    public void alterarDespesa(int mes, int semana, double valor) {
        atualizar(despesas, mes, semana, valor, "alterar");
    }

    public void excluirDespesa(int mes, int semana) {
        atualizar(despesas, mes, semana, 0, "excluir");
    }

    // ---------------- Receitas ----------------
    public void cadastrarReceita(int mes, int semana, double valor) {
        atualizar(receitas, mes, semana, valor, "cadastrar");
    }

    public void alterarReceita(int mes, int semana, double valor) {
        atualizar(receitas, mes, semana, valor, "cadastrar");
    }

    public void excluirReceita(int mes, int semana) {
        atualizar(receitas, mes, semana, 0, "excluir");
    }

    // ---------------- Estatísticas ----------------
    public void verEstatisticas() {
        System.out.println("------- DESPESAS & RECEITAS -------");

        for (int i = 0; i < 12; i++) {
            double somaDespesa = 0, somaReceita = 0;

            for (int j = 0; j < 4; j++) {
                somaDespesa += despesas[i][j];
                somaReceita += receitas[i][j];
            }


            double saldo = somaReceita - somaDespesa;
            System.out.printf("%s --> Receitas: %.2f | Despesas: %.2f | Saldo: %.2f%n",
                    MESES[i], somaReceita, somaDespesa, saldo);
        }
    }

    // ---------------- Lista de Meses ----------------
    public void listarMeses() {
        for (int i = 0; i < MESES.length; i++) {
            System.out.println((i + 1) + " - " + MESES[i]);
        }
    }
}