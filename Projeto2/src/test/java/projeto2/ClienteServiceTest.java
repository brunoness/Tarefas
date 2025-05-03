package projeto2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto2.domain.Cliente;
import projeto2.service.IClienteService;
import projeto2.service.ClienteService;
import projeto2.DAO.GenericDAOMock;

public class ClienteServiceTest {

	private IClienteService clienteService;

    @Before
    public void setUp() {
        clienteService = new ClienteService(new GenericDAOMock<>());
    }

    @Test
    public void deveSalvarClienteComSucesso() {
        Cliente cliente = new Cliente(1L, "João", 1234);
        clienteService.salvar(cliente);
        Cliente resultado = clienteService.buscar(1L);

        Assert.assertNotNull(resultado);
        Assert.assertEquals("João", resultado.getNome());
    }

    @Test
    public void deveAtualizarCliente() {
        Cliente cliente = new Cliente(1L, "João", 12345);
        clienteService.salvar(cliente);
        cliente.setNome("João da Silva");
        clienteService.atualizar(cliente);

        Cliente atualizado = clienteService.buscar(1L);
        Assert.assertEquals("João da Silva", atualizado.getNome());
    }

    @Test
    public void deveExcluirCliente() {
        Cliente cliente = new Cliente(2L, "Maria", 321);
        clienteService.salvar(cliente);
        clienteService.excluir(2L);

        Cliente resultado = clienteService.buscar(2L);
        Assert.assertNull(resultado);
    }
}