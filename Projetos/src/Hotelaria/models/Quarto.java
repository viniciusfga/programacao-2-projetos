package Hotelaria.models;

public class Quarto {

    public int numero;
    public String tipo;
    public double valorDiaria;
    public boolean ocupado;

    public Quarto(int numero, String tipo, double valorDiaria, boolean ocupado) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return numero + ";" + tipo + ";" + valorDiaria + ";" + ocupado;
    }
}
