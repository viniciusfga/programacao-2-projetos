package HotelariaV1;

import HotelariaV1.services.HospedeService;

public class Gerenciar {

    HospedeService service = new HospedeService();

    // GERENCIAR HOSPEDES
    public void gerenciarHospedes() {
        int escolha = Utils.lerInt("""
                \n=== Gerenciar Hóspedes ===
                  1) Cadastrar hóspede
                  2) Listar hóspedes
                  3) Remover hóspede
                  4) Apagar todos
                  5) Sair
                  Escolha: """);

        switch (escolha) {
            case 1 -> service.cadastrarHospede();
            case 2 -> service.listarHospedes();
            case 3 -> service.removerHospede();
            case 4 -> service.apagarTodos();
            case 5 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }
}

