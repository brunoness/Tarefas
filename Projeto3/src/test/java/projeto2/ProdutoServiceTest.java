package projeto2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projeto2.DAO.ProdutoDAO;
import projeto2.DAO.jdbc.*;
import projeto2.domain.Produto;
import projeto2.service.ProdutoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoServiceTest {

    private ProdutoService produtoService;

    @Before
    public void setUp() {
        produtoService = new ProdutoService(new ProdutoDAO());
    }

    // Limpa o teste
    @After
    public void tearDown() {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM produto")) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deveCadastrarProduto() {
        Produto produto = new Produto(1L, "Teclado", 150.00);
        boolean resultado = produtoService.cadastrar(produto);

        assertTrue(resultado);

        Produto encontrado = produtoService.consultar(1L);
        assertNotNull(encontrado);
        assertEquals("Teclado", encontrado.getNome());
        assertEquals(150.00, encontrado.getPreco(), 0.01);
    }

    @Test
    public void deveListarProdutos() {
        produtoService.cadastrar(new Produto(1L, "Teclado", 150.00));
        produtoService.cadastrar(new Produto(2L, "Mouse", 80.00));

        List<Produto> produtos = produtoService.buscarTodos();
        assertEquals(2, produtos.size());
    }

    @Test
    public void deveAlterarProduto() {
        Produto produto = new Produto(1L, "Teclado", 150.00);
        produtoService.cadastrar(produto);

        produto.setNome("Teclado Mecânico");
        produto.setPreco(200.00);
        produtoService.alterar(produto);

        Produto atualizado = produtoService.consultar(1L);
        assertEquals("Teclado Mecânico", atualizado.getNome());
        assertEquals(200.00, atualizado.getPreco(), 0.01);
    }

    @Test
    public void deveExcluirProduto() {
        produtoService.cadastrar(new Produto(1L, "Teclado", 150.00));
        produtoService.excluir(1L);

        Produto produto = produtoService.consultar(1L);
        assertNull(produto);
    }
}
