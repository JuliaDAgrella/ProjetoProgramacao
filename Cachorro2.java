public class Cachorro2 { // Renomeado para Cachorro2
    private String nome;
    private String cor;
    private String dono;

    // Construtor padrão
    public Cachorro2() {
        this.nome = "sem nome";
        this.cor = "indefinida";
        this.dono = "sem dono";
    }

    // Construtor com nome e cor
    public Cachorro2(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.dono = "sem dono";
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    // Método para exibir informações do cachorro
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cor: " + cor);
        System.out.println("Dono: " + dono);
        System.out.println("--------------------");
    }
}