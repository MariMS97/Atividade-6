import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;


class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    void setUp() {
        estoque = new Estoque();
    }

    @Test
    void testAdicionarProduto() {
        Produto produto = new Produto("123", "Produto A", 10);
        assertTrue(estoque.adicionarProduto(produto), "O produto deve ser adicionado com sucesso.");
        assertEquals(1, estoque.listarProdutos().size(), "O estoque deve conter um produto.");
    }

    @Test
    void testAdicionarProdutoDuplicado() {
        Produto produto = new Produto("123", "Produto A", 10);
        assertTrue(estoque.adicionarProduto(produto), "Primeira adição do produto deve retornar verdadeiro.");
        assertFalse(estoque.adicionarProduto(produto), "Adicionar um produto duplicado deve retornar falso.");
    }

    @Test
    void testBuscarProdutoExistente() {
        Produto produto = new Produto("123", "Produto A", 10);
        estoque.adicionarProduto(produto);
        Produto encontrado = estoque.buscarProduto("Produto A");
        assertNotNull(encontrado, "O produto deve ser encontrado.");
        assertEquals("Produto A", encontrado.getNome(), "O nome do produto encontrado deve ser 'Produto A'.");
    }

    @Test
    void testBuscarProdutoInexistente() {
        assertNull(estoque.buscarProduto("Produto Inexistente"), "Busca por um produto não existente deve retornar null.");
    }

    @Test
    void testRemoverProdutoExistente() {
        Produto produto = new Produto("123", "Produto A", 10);
        estoque.adicionarProduto(produto);
        assertTrue(estoque.removerProduto("Produto A"), "Remover um produto existente deve retornar verdadeiro.");
        assertEquals(0, estoque.listarProdutos().size(), "O estoque deve ficar vazio após a remoção.");
    }

    @Test
    void testRemoverProdutoInexistente() {
        assertFalse(estoque.removerProduto("Produto Inexistente"), "Remover um produto inexistente deve retornar falso.");
    }

    @Test
    void testListarProdutos() {
        Produto produto1 = new Produto("123", "Produto A", 10);
        Produto produto2 = new Produto("124", "Produto B", 5);
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        Set<Produto> produtos = estoque.listarProdutos();
        assertEquals(2, produtos.size(), "O estoque deve conter dois produtos.");
        assertTrue(produtos.contains(produto1), "O estoque deve conter 'Produto A'.");
        assertTrue(produtos.contains(produto2), "O estoque deve conter 'Produto B'.");
    }
}
