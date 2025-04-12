// Júlia D’Agrella Araújo - RA: 10426655
// Rafael Carvalho Cordeiro - RA: 10437533

public class Cachorro {
    private String nome;
    private String cor;
    private String dono;

    // Construtor padrão
    public Cachorro() {
        this.nome = "sem nome";
        this.cor = "indefinida";
        this.dono = "sem dono";
    }

    // Construtor com nome e cor
    public Cachorro(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.dono = "sem dono";
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", Cor: " + cor + ", Dono: " + dono);
    }
}
