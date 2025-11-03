package Hotelaria.models;

public class Reserva {

    private Hospede hospede;
    private Quarto quarto;
    private String dataEntrada;
    private String dataSaida;
    private double valorTotal;

    // Getters e Setters
    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Reserva de " + hospede.getNome() +
                " no quarto " + quarto.getNumero() +
                " | Entrada: " + dataEntrada +
                " | Saída: " + dataSaida +
                " | Valor total: R$ " + valorTotal;
    }
}
