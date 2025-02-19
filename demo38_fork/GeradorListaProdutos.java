import java.util.ArrayList;
import java.util.List;

// GeradorListaProdutos - Gera uma lista de produtos com preços iniciais
public class GeradorListaProdutos {
    public List<Produto> gerar(int tamanho) {
        List<Produto> lista = new ArrayList<>();

        for (int i = 0; i < tamanho; i++) {
            Produto produto = new Produto();
            produto.setNome("Produto " + i);
            produto.setPreco(10);
            lista.add(produto);
        }
        return lista;
    }
}
