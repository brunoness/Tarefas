package projeto2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projeto2.DAO.ClienteDAO;
import projeto2.DAO.EstoqueDAO;
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
    private EstoqueDAO estoqueDAO;
    
    private Produto produto1;
    private Produto produto2;

    @Before
    public void setUp() {
        clienteService = new ClienteService(new ClienteDAO());
        produtoService = new ProdutoService(new ProdutoDAO());
        vendaService = new VendaService(new VendaDAO());
        estoqueDAO = new EstoqueDAO();

        clienteService.cadastrar(new Cliente(1L, "João", "12345678900", "12345-6789"));
        produto1 = new Produto(1L, "Teclado", 150.00);
        produto2 = new Produto(2L, "Mouse", 80.00);
        produtoService.cadastrar(produto1);
        produtoService.cadastrar(produto2);

        
        estoqueDAO.cadastrar(new Estoque(1L, produto1, 5));
        estoqueDAO.cadastrar(new Estoque(2L, produto2, 5));
        
    }

    // Limpa o teste
    @After
    public void tearDown() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.prepareStatement("DELETE FROM venda").executeUpdate();
            conn.prepareStatement("DELETE FROM estoque").executeUpdate();
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
    public void deveCadastrarVendaEReduzirEstoque() {
        Cliente cliente = clienteService.consultar(1L);
        List<Produto> produtos = Arrays.asList(produto1, produto2);

        Venda venda = new Venda(1L, cliente, produtos);
        boolean resultado = vendaService.cadastrar(venda);
        assertTrue(resultado);

        Estoque estoqueTeclado = estoqueDAO.consultar(1L);
        Estoque estoqueMouse = estoqueDAO.consultar(2L);
        assertEquals(4, estoqueTeclado.getQuantidade());
        assertEquals(4, estoqueMouse.getQuantidade());
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