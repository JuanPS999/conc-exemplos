// Produto - Representa um produto com nome e preço
public class Produto {
    private String nome;
    private double preco;

    // Retorna o nome do produto
    public String getNome() {
        return nome;
    }

    // Define o nome do produto
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o preço do produto
    public double getPreco() {
        return preco;
    }

    // Define o preço do produto
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
