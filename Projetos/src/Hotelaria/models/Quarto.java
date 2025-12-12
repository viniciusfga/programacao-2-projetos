package Hotelaria.models;

public class Quarto {
    public int numero;
    public String tipo;
    public double valorDiaria;
    public boolean disponivel;

    public Quarto(int numero, String tipo, double valorDiaria, boolean disponivel) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return numero + ";" + tipo + ";" + valorDiaria + ";" + disponivel;
    }
}
