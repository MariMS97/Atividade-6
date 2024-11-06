
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProdutoTest {
    @Test
    void testCriacaoProduto() {
        Produto produto = new Produto("123", "Produto A", 10);
        assertEquals("123", produto.getCodigo());
        assertEquals("Produto A", produto.getNome());
        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void testAtualizarQuantidade() {
        Produto produto = new Produto("123", "Produto A", 10);
        produto.setQuantidade(20);
        assertEquals(20, produto.getQuantidade());
    }

    @Test
    void testAtualizarQuantidadeNegativa() {
        Produto produto = new Produto("123", "Produto A", 10);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            produto.setQuantidade(-5);
        });
        assertEquals("Quantidade não pode ser negativa", exception.getMessage());
    }

    @Test
    void testEquals() {
        Produto produto1 = new Produto("123", "Produto A", 10);
        Produto produto2 = new Produto("123", "Produto A", 10);
        assertEquals(produto1, produto2);
    }

}
