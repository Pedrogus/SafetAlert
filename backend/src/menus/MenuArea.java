package menus;

import com.models.AreaDeRisco;
import com.services.AreaDeRiscoService;

import java.util.Random;
import java.util.Scanner;

public class MenuArea {
    private AreaDeRiscoService areaDeRiscoService;
    private Scanner scanner;


    public MenuArea(AreaDeRiscoService areaDeRiscoService) {
        this.areaDeRiscoService = areaDeRiscoService;
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao = -1;

        while(opcao != 0) {
            System.out.println("\n=== Menu Área de Risco ===");
            System.out.println("1. Cadastrar Área de Risco");
            System.out.println("2. Listar Áreas de Risco");
            System.out.println("3. Buscar Área de Risco por ID");
            System.out.println("4. Atualizar Área de Risco");
            System.out.println("5. Remover Área de Risco");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarAreaDeRisco();
                    break;
                case 2:
                    listarAreasDeRisco();
                    break;
                case 3:
                    buscarAreaDeRisco();
                    break;
                case 4:
                    atualizarAreaDeRisco();
                    break;
                case 5:
                    removerAreaDeRisco();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
    }

    private void cadastrarAreaDeRisco() {
        System.out.print("Digite a descrição da área de risco: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a cordenada da área de risco: ");
        String localizacao = scanner.nextLine();

        System.out.print("Digite o status (VERDADEIRO/FALSO): ");
        String resposta = scanner.nextLine().toUpperCase();

        boolean status = resposta.equals("VERDADEIRO") || resposta.equals("V");

        int id = gerarIdAleatorio();

        AreaDeRisco areaDeRisco = new AreaDeRisco(id, descricao, localizacao, status);
        areaDeRiscoService.cadastrar(areaDeRisco);

        System.out.println("Área de risco cadastrada com sucesso! ID: " + id);
    }

    private void listarAreasDeRisco() {
        System.out.println("\n=== Lista de Áreas de Risco ===");
        for (AreaDeRisco area : areaDeRiscoService.listar()) {
            System.out.println(area);
        }
    }

    private void buscarAreaDeRisco() {
        System.out.print("Digite o ID da área de risco que deseja buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AreaDeRisco area = areaDeRiscoService.buscarPorId(id);
        if (area != null) {
            System.out.println("Área de risco encontrada: " + area);
        } else {
            System.out.println("Área de risco não encontrada.");
        }
    }

    private void atualizarAreaDeRisco() {
        System.out.print("Digite o ID da área de risco que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a nova descrição: ");
        String novaDescricao = scanner.nextLine();

        System.out.print("Digite a nova cordenada: ");
        String novaLocalizacao = scanner.nextLine();

        System.out.print("Digite o status (VERDADEIRO/FALSO): ");
        String resposta = scanner.nextLine().toUpperCase();

        boolean novoStatus = resposta.equals("VERDADEIRO") || resposta.equals("V");

        areaDeRiscoService.atualizar(id, novaDescricao, novaLocalizacao, novoStatus);
        System.out.println("Área de risco atualizada com sucesso.");
    }

    private void removerAreaDeRisco() {
        System.out.print("Digite o ID da área de risco que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        areaDeRiscoService.deletar(id);
        System.out.println("Área de risco removida com sucesso.");
    }

    private int gerarIdAleatorio() {
        Random random = new Random();
        return random.nextInt(100) + 1;  // Gera número entre 1 e 100
    }

}
