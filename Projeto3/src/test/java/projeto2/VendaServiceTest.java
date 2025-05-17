package projeto2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projeto2.DAO.ClienteDAO;
import projeto2.DAO.ProdutoDAO;
import projeto2.DAO.VendaDAO;
import projeto2.DAO.jdbc.*;
import projeto2.domain.*;
import projeto2.service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VendaServiceTest {

    private ClienteService clienteService;
    private ProdutoService produtoService;
    private VendaService vendaService;

    @Before
    public void setUp() {
        clienteService = new ClienteService(new ClienteDAO());
        produtoService = new ProdutoService(new ProdutoDAO());
        vendaService = new VendaService(new VendaDAO());

        clienteService.cadastrar(new Cliente(1L, "João", "12345678900"));
        produtoService.cadastrar(new Produto(1L, "Teclado", 150.00));
        produtoService.cadastrar(new Produto(2L, "Mouse", 80.00));
    }

    // Limpa o teste
    @After
    public void tearDown() {
        try (Connection conn = ConnectionFactory.getConnection()) {

            conn.prepareStatement("DELETE FROM venda").executeUpdate();
            conn.prepareStatement("DELETE FROM cliente").executeUpdate();
            conn.prepareStatement("DELETE FROM produto").executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deveCadastrarVenda() {
        Cliente cliente = clienteService.consultar(1L);
        List<Produto> produtos = produtoService.buscarTodos();

        Venda venda = new Venda(1L, cliente, produtos);
        boolean resultado = vendaService.cadastrar(venda);

        assertTrue(resultado);

        Venda encontrada = vendaService.consultar(1L);
        assertNotNull(encontrada);
        assertEquals(cliente.getNome(), encontrada.getCliente().getNome());
        assertEquals(2, encontrada.getProdutos().size());
        assertEquals(230.00, encontrada.getTotal(), 0.01);
    }

    @Test
    public void deveExcluirVenda() {
        Cliente cliente = clienteService.consultar(1L);
        List<Produto> produtos = produtoService.buscarTodos();

        Venda venda = new Venda(1L, cliente, produtos);
        vendaService.cadastrar(venda);

        vendaService.excluir(1L);
        Venda excluida = vendaService.consultar(1L);
        assertNull(excluida);
    }

    @Test
    public void deveAlterarVenda() {
        Cliente cliente = clienteService.consultar(1L);
        List<Produto> produtos = produtoService.buscarTodos();

        Venda venda = new Venda(1L, cliente, produtos);
        vendaService.cadastrar(venda);

        venda.setProdutos(Arrays.asList(produtos.get(0)));
        vendaService.alterar(venda);

        Venda atualizada = vendaService.consultar(1L);
        assertEquals(1, atualizada.getProdutos().size());
        assertEquals(150.00, atualizada.getTotal(), 0.01);
    }

    @Test
    public void deveListarVendas() {
        Cliente cliente = clienteService.consultar(1L);
        List<Produto> produtos = produtoService.buscarTodos();

        vendaService.cadastrar(new Venda(1L, cliente, produtos));
        vendaService.cadastrar(new Venda(2L, cliente, Arrays.asList(produtos.get(0))));

        List<Venda> vendas = vendaService.buscarTodos();
        assertEquals(2, vendas.size());
    }
}