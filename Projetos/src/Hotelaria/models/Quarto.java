package Hotelaria.models;

public class Quarto {

    private int numero;
    private String tipo; // Ex: "Simples", "Duplo", "Suíte"
    private double valorDiaria;
    private String dataEntrada;
    private String dataSaida;
    private boolean disponivel;

    public Quarto() {}

    public Quarto(int numero, String tipo, double valorDiaria, String dataEntrada, String dataSaida, boolean disponivel) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.disponivel = disponivel;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "Numero = " + numero +
                ", tipo='" + tipo + '\'' +
                ", valorDiaria=" + valorDiaria +
                ", dataEntrada='" + dataEntrada + '\'' +
                ", dataSaida='" + dataSaida + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}
