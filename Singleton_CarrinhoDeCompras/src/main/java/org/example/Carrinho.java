package padroescriacao.singleton;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static Carrinho instance;

    private List<Produto> produtos;

    private Carrinho() {
        produtos = new ArrayList<>();
    }

    public static Carrinho getInstance() {
        if (instance == null) {
            instance = new Carrinho();
        }
        return instance;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }

    public void exibirCarrinho() {
        System.out.println("=== CARRINHO ===");
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - R$ " + p.getPreco());
        }
        System.out.println("Total: R$ " + getTotal());
    }
}