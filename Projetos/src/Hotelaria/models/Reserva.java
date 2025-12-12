package Hotelaria.models;

public class Reserva {

    public final String cpfHospede;
    public final int numeroQuarto;
    public final String dataEntrada;
    public final String dataSaida;
    public final double valorTotal;

    public Reserva(String cpfHospede, int numeroQuarto, String dataEntrada, String dataSaida, double valorTotal) {
        this.cpfHospede = cpfHospede;
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cpf='" + cpfHospede + '\'' +
                ", quarto=" + numeroQuarto +
                ", entrada='" + dataEntrada + '\'' +
                ", saída='" + dataSaida + '\'' +
                ", valor=" + valorTotal +
                '}';
    }
}
