import menus.menuPessoa;
import com.services.PessoaService;
import com.services.AlertaService;
import com.services.AreaDeRiscoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        AlertaService alertaService = new AlertaService();
        AreaDeRiscoService areaDeRiscoService = new AreaDeRiscoService();

        menuPessoa menuPessoa = new menuPessoa(pessoaService, scanner);

        int opcao;

        do {
            System.out.println("\n=== Sistema de Alerta de Desastres ===");
            System.out.println("1. Gerenciar Pessoas");
            System.out.println("2. Gerenciar Áreas de Risco");
            System.out.println("3. Gerenciar Alertas");
            System.out.println("4. Simular envio de alerta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    menuPessoa.exibir();
                    break;
                case 2:
                   // menuArea
                    break;
                case 3:
                    // menuAlerta
                    break;
                case 4:
                    // simularEnvioAlerta
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    }