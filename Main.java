

import java.util.Scanner;

public class Main {
    static Cachorro[] meusCachorros = new Cachorro[10];
    static int totalCaes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar novo cão");
            System.out.println("2. Buscar cão por nome");
            System.out.println("3. Listar todos os cães");
            System.out.println("4. Atribuir dono a um cão");
            System.out.println("5. Listar cães sem dono");
            System.out.println("6. Listar cães com dono");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();  // limpar buffer

            switch (opcao) {
                case 1 -> cadastrarCao(sc);
                case 2 -> buscarCao(sc);
                case 3 -> exibirDados();
                case 4 -> atribuirDono(sc);
                case 5 -> exibirCaesSemDonos();
                case 6 -> exibirCaesComDonos();
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        sc.close();
    }

    static void cadastrarCao(Scanner sc) {
        if (totalCaes >= meusCachorros.length) {
            System.out.println("Limite de cães atingido!");
            return;
        }

        System.out.print("Nome do cão: ");
        String nome = sc.nextLine();
        System.out.print("Cor do cão: ");
        String cor = sc.nextLine();

        meusCachorros[totalCaes] = new Cachorro(nome, cor);
        totalCaes++;
        System.out.println("Cão cadastrado com sucesso!");
    }

    static void buscarCao(Scanner sc) {
        System.out.print("Nome do cão para busca: ");
        String nome = sc.nextLine();

        for (int i = 0; i < totalCaes; i++) {
            if (meusCachorros[i].getNome().equalsIgnoreCase(nome)) {
                meusCachorros[i].exibirInfo();
                return;
            }
        }

        System.out.println("Cão não encontrado.");
    }

    static void exibirDados() {
        for (int i = 0; i < totalCaes; i++) {
            meusCachorros[i].exibirInfo();
        }
    }

    static void exibirCaesSemDonos() {
        for (int i = 0; i < totalCaes; i++) {
            if (meusCachorros[i].getDono().equalsIgnoreCase("sem dono")) {
                meusCachorros[i].exibirInfo();
            }
        }
    }

    static void exibirCaesComDonos() {
        for (int i = 0; i < totalCaes; i++) {
            if (!meusCachorros[i].getDono().equalsIgnoreCase("sem dono")) {
                meusCachorros[i].exibirInfo();
            }
        }
    }

    static void atribuirDono(Scanner sc) {
        System.out.print("Nome do cão: ");
        String nome = sc.nextLine();

        for (int i = 0; i < totalCaes; i++) {
            if (meusCachorros[i].getNome().equalsIgnoreCase(nome)) {
                System.out.print("Nome do novo dono: ");
                String dono = sc.nextLine();
                meusCachorros[i].setDono(dono);
                System.out.println("Dono atribuído com sucesso!");
                return;
            }
        }

        System.out.println("Cão não encontrado.");
    }
}


