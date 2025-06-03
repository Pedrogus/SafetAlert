package menus;

import com.models.Alerta;
import com.services.AlertaService;

import java.util.Random;
import java.util.Scanner;

public class MenuAlerta {

        AlertaService alertaService = new AlertaService();
        Scanner scanner = new Scanner(System.in);

    public MenuAlerta(AlertaService alertaService) {
            this.alertaService = alertaService;
            this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Menu Alerta ===");
            System.out.println("1. Cadastrar Alerta");
            System.out.println("2. Listar Alertas");
            System.out.println("3. Buscar Alerta por ID");
            System.out.println("4. Atualizar Alerta");
            System.out.println("5. Remover Alerta");
            System.out.println("6. Enviar Alerta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarAlerta();
                    break;
                  case 2:
                      listarAlertas();
                      break;
                  case 3:
                     buscarAlerta();
                      break;
                  case 4:
                     atualizarAlerta();
                      break;
                  case 5:
                     removerAlerta();
                      break;
                  case 6:
                    enviarAlerta();
                    break;
                case 0:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }

    private void cadastrarAlerta() {
        System.out.print("Digite a mensagem do alerta: ");
        String mensagem = scanner.nextLine();

        System.out.print("Digite o ID da Área de Risco associada: ");
        int areaDeRiscoId = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer

        int id = gerarIdAleatorio();

        Alerta alerta = new Alerta(id, mensagem, areaDeRiscoId);
        alertaService.cadastrar(alerta);

        System.out.println("Alerta cadastrado com sucesso! ID: " + id);
    }

    private void listarAlertas() {
        System.out.println("\n=== Lista de Alertas ===");
        for (Alerta alerta : alertaService.listar()) {
            System.out.println(alerta);
        }
    }

    private void buscarAlerta() {
        System.out.print("Digite o ID do alerta que deseja buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Alerta alerta = alertaService.buscarPorId(id);
        if(alerta != null) {
            System.out.println("Alerta encontrado: " + alerta);
        } else {
            System.out.println("Alerta inexistente!");
        }
    }


    private  void atualizarAlerta() {
        System.out.print("Digite o ID do alerta que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a nova mensagem do alerta: ");
        String novaMensagem = scanner.nextLine();

        System.out.print("Digite o novo ID da Área de Risco: ");
        int novoAreaDeRiscoId = scanner.nextInt();
        scanner.nextLine();

        alertaService.atualizar(id, novaMensagem, novoAreaDeRiscoId);
        System.out.println("Alerta atualizado com sucesso.");
    }

    private void removerAlerta() {
        System.out.print("Digite o ID do alerta que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        alertaService.deletar(id);
        System.out.println("Alerta removido com sucesso.");
    }


    private void enviarAlerta() {
        System.out.print("Digite a mensagem do alerta: ");
        String mensagem = scanner.nextLine();

        System.out.print("Digite o ID da área de risco para enviar o alerta: ");
        int areaDeRiscoId = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        int id = gerarIdAleatorio();

        Alerta alerta = new Alerta(id, mensagem, areaDeRiscoId);
        alertaService.cadastrar(alerta);

        System.out.println("Alerta enviado com sucesso para a Área de Risco ID: " + areaDeRiscoId);
        System.out.println("Mensagem: " + mensagem);
    }


    private int gerarIdAleatorio() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
