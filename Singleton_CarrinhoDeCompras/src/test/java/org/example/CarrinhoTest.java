package padroescriacao.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    void limparCarrinho() {
        carrinho = Carrinho.getInstance();
        carrinho.getProdutos().clear();
    }

    @Test
    void deveAdicionarProduto() {
        Produto produto = new Produto("Mouse", 50.0);
        carrinho.adicionarProduto(produto);
        assertEquals(1, carrinho.getProdutos().size());
        assertEquals("Mouse", carrinho.getProdutos().get(0).getNome());
    }

    @Test
    void deveRemoverProduto() {
        Produto produto = new Produto("Teclado", 100.0);
        carrinho.adicionarProduto(produto);
        carrinho.removerProduto(produto);
        assertTrue(carrinho.getProdutos().isEmpty());
    }

    @Test
    void deveCalcularTotal() {
        carrinho.adicionarProduto(new Produto("Mouse", 50.0));
        carrinho.adicionarProduto(new Produto("Teclado", 100.0));
        double total = carrinho.getTotal();
        assertEquals(150.0, total);
    }

    @Test
    void deveCompartilharMesmaInstancia() {
        Carrinho c1 = Carrinho.getInstance();
        Carrinho c2 = Carrinho.getInstance();
        assertSame(c1, c2);
    }

    @Test
    void carrinhoDeveComecarVazio() {
        assertEquals(0, carrinho.getProdutos().size());
    }
}