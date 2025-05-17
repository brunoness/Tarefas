package projeto2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projeto2.DAO.ClienteDAO;
import projeto2.domain.Cliente;
import projeto2.service.ClienteService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteServiceTest {

    private ClienteService clienteService;

    @Before
    public void setUp() {
        clienteService = new ClienteService(new ClienteDAO());
    }

    // Limpa o teste
    @After
    public void tearDown() {
        try (Connection conn = projeto2.DAO.jdbc.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM cliente")) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deveCadastrarCliente() {
        Cliente cliente = new Cliente(1L, "João", "12345678900");
        boolean resultado = clienteService.cadastrar(cliente);

        assertTrue(resultado);

        Cliente encontrado = clienteService.consultar(1L);
        assertNotNull(encontrado);
        assertEquals("João", encontrado.getNome());
        assertEquals("12345678900", encontrado.getCpf());
    }

    @Test
    public void deveListarClientes() {
        clienteService.cadastrar(new Cliente(1L, "João", "12345678900"));
        clienteService.cadastrar(new Cliente(2L, "Maria", "98765432100"));

        List<Cliente> clientes = clienteService.buscarTodos();
        assertEquals(2, clientes.size());
    }

    @Test
    public void deveAlterarCliente() {
        Cliente cliente = new Cliente(1L, "João", "12345678900");
        clienteService.cadastrar(cliente);

        cliente.setNome("João da Silva");
        clienteService.alterar(cliente);

        Cliente atualizado = clienteService.consultar(1L);
        assertEquals("João da Silva", atualizado.getNome());
    }

    @Test
    public void deveExcluirCliente() {
        clienteService.cadastrar(new Cliente(1L, "João", "12345678900"));
        clienteService.excluir(1L);
    }
}