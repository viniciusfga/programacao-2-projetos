package Hotelaria.models;

public class Hospede {
    public int id;
    public String nome;
    public String cpf;
    public String rg;
    public String celular;
    public String email;

    public Hospede(int id, String nome, String cpf, String rg, String celular, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.celular = celular;
        this.email = email;
    }
    
}

