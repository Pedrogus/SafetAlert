package menus;

import com.models.Pessoa;
import com.services.PessoaService;

import java.util.Scanner;
import java.util.Random;

public class MenuPessoa {
    private PessoaService pessoaService;
    private Scanner scanner;
    private Random random = new Random();

    public MenuPessoa(PessoaService pessoaService, Scanner scanner) {
        this.pessoaService = pessoaService;
        this.scanner = scanner;
    }

    public void exibir() {
        int opcao = -1;


        while (opcao != 0) {
        System.out.println("\n--- Gerenciar Pessoas ---");
        System.out.println("1. Cadastrar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Atualizar");
        System.out.println("5. Deletar");
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                cadastrar();
                break;
            case 2:
                listar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                atualizar();
                break;
            case 5:
                deletar();
                break;
            case 0:
                System.out.println("Saindo para o menu principal..: ");
            default:
                System.out.println("Opção inválida.");
        }
    }
    }

    private void cadastrar() {
        int id = random.nextInt(100) + 1;
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CEP: ");
        String local = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        pessoaService.cadastrar(new Pessoa(id, nome, local, telefone));
    }

    private void listar() {
        pessoaService.listar().forEach(System.out::println);
    }

    private void buscar() {
        System.out.print("ID: ");
        Pessoa p = pessoaService.buscarPorId(scanner.nextInt());
        System.out.println(p != null ? p : "Não encontrado.");
    }

    private void atualizar() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo CEP: ");
        String local = scanner.nextLine();
        System.out.print("Nova telefone: ");
        String telefone = scanner.nextLine();
        pessoaService.atualizar(id, nome, local,telefone);
    }

    private void deletar() {
        System.out.print("ID: ");
        pessoaService.deletar(scanner.nextInt());
    }

}

