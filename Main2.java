import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Cachorro2[] meusCachorros = new Cachorro2[10]; // Vetor de Cachorro2
        int qtdCaes = 0;
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarCachorro(meusCachorros, qtdCaes, scanner);
                    qtdCaes++;
                    break;
                case 2:
                    buscarCachorro(meusCachorros, qtdCaes, scanner);
                    break;
                case 3:
                    exibirDados(meusCachorros, qtdCaes);
                    break;
                case 4:
                    atribuirDono(meusCachorros, qtdCaes, scanner);
                    break;
                case 5:
                    exibirCaesSemDonos(meusCachorros, qtdCaes);
                    break;
                case 6:
                    exibirCaesComDonos(meusCachorros, qtdCaes);
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    // Método para exibir o menu de opções
    public static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Cadastrar novo cão");
        System.out.println("2. Buscar informações de um cão");
        System.out.println("3. Listar informações de todos os cães");
        System.out.println("4. Atribuir dono a um cão");
        System.out.println("5. Listar cães sem donos");
        System.out.println("6. Listar cães adotados");
        System.out.println("7. Sair");
    }

    // Método para cadastrar um novo cão
    public static void cadastrarCachorro(Cachorro2[] meusCachorros, int qtdCaes, Scanner scanner) { // Usa Cachorro2
        if (qtdCaes < meusCachorros.length) {
            System.out.print("Digite o nome do cão: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a cor do cão: ");
            String cor = scanner.nextLine();
            meusCachorros[qtdCaes] = new Cachorro2(nome, cor); // Cria Cachorro2
            System.out.println("Cão cadastrado com sucesso!");
        } else {
            System.out.println("Limite de cães atingido.");
        }
    }

    // Método para buscar um cão pelo nome
    public static void buscarCachorro(Cachorro2[] meusCachorros, int qtdCaes, Scanner scanner) { // Usa Cachorro2
        System.out.print("Digite o nome do cão que deseja buscar: ");
        String nomeBusca = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < qtdCaes; i++) {
            if (meusCachorros[i].getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("Cão encontrado:");
                meusCachorros[i].exibirInformacoes();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cão não encontrado.");
        }
    }

    // Método para exibir informações de todos os cães
    public static void exibirDados(Cachorro2[] meusCachorros, int qtdCaes) { // Usa Cachorro2
        if (qtdCaes == 0) {
            System.out.println("Não há cães cadastrados.");
        } else {
            System.out.println("\n--- Lista de todos os cães ---");
            for (int i = 0; i < qtdCaes; i++) {
                meusCachorros[i].exibirInformacoes();
            }
        }
    }

    // Método para atribuir um dono a um cão
    public static void atribuirDono(Cachorro2[] meusCachorros, int qtdCaes, Scanner scanner) { // Usa Cachorro2
        System.out.print("Digite o nome do cão para atribuir um dono: ");
        String nomeBusca = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < qtdCaes; i++) {
            if (meusCachorros[i].getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.print("Digite o nome do novo dono: ");
                String novoDono = scanner.nextLine();
                meusCachorros[i].setDono(novoDono);
                System.out.println("Dono atribuído com sucesso!");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cão não encontrado.");
        }
    }

    // Método para exibir cães sem donos
    public static void exibirCaesSemDonos(Cachorro2[] meusCachorros, int qtdCaes) { // Usa Cachorro2
        boolean algumSemDono = false;
        System.out.println("\n--- Lista de cães sem donos ---");
        for (int i = 0; i < qtdCaes; i++) {
            if (meusCachorros[i].getDono().equalsIgnoreCase("sem dono")) {
                meusCachorros[i].exibirInformacoes();
                algumSemDono = true;
            }
        }
        if (!algumSemDono) {
            System.out.println("Não há cães sem donos.");
        }
    }

    // Método para exibir cães com donos
    public static void exibirCaesComDonos(Cachorro2[] meusCachorros, int qtdCaes) { // Usa Cachorro2
        boolean algumComDono = false;
        System.out.println("\n--- Lista de cães adotados ---");
        for (int i = 0; i < qtdCaes; i++) {
            if (!meusCachorros[i].getDono().equalsIgnoreCase("sem dono")) {
                meusCachorros[i].exibirInformacoes();
                algumComDono = true;
            }
        }
        if (!algumComDono) {
            System.out.println("Não há cães adotados.");
        }
    }
}