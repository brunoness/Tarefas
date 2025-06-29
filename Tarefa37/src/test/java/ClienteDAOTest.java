

import DAO.ClienteDAO;
import DAO.IClienteDAO;
import domain.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;
    private Random rd;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
        rd = new Random();
    }

    @Before
    public void init() {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (Exception e) {
            	
            }
        });
    }

    @After
    public void end() {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (Exception e) {
            	
            }
        });
    }

    @Test
    public void pesquisarCliente() {
        Cliente cliente = createCliente();
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        assertNotNull(clienteConsultado);
        assertEquals(cliente.getNome(), clienteConsultado.getNome());
        assertEquals(cliente.getCpf(), clienteConsultado.getCpf());
    }

    @Test
    public void salvarCliente() {
        Cliente cliente = createCliente();
        Cliente clienteSalvo = clienteDao.cadastrar(cliente);
        assertNotNull(clienteSalvo);
        assertNotNull(clienteSalvo.getId());
    }


    @Test
    public void excluirCliente() {
        Cliente cliente = createCliente();
        Cliente clienteSalvo = clienteDao.cadastrar(cliente);
        assertNotNull(clienteSalvo);

        clienteDao.excluir(clienteSalvo);
        Cliente clienteConsultado = clienteDao.consultar(clienteSalvo.getId());
        assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() {
        Cliente cliente = createCliente();
        Cliente clienteSalvo = clienteDao.cadastrar(cliente);
        assertNotNull(clienteSalvo);

        clienteSalvo.setNome("Nome Alterado");
        Cliente clienteAlterado = clienteDao.alterar(clienteSalvo);
        assertNotNull(clienteAlterado);
        assertEquals("Nome Alterado", clienteAlterado.getNome());

        Cliente clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        assertNotNull(clienteConsultado);
        assertEquals("Nome Alterado", clienteConsultado.getNome());
    }

    @Test
    public void buscarTodos() {
        Cliente cliente1 = createCliente();
        clienteDao.cadastrar(cliente1);

        Cliente cliente2 = createCliente();
        clienteDao.cadastrar(cliente2);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

    }

    private Cliente createCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Teste Cliente");
        cliente.setCidade("Teste Cidade");
        cliente.setEndereco("Teste End");
        cliente.setEstado("TS");
        cliente.setNumero(10);
        cliente.setTelefone(11999999999L);
        return cliente;
    }
}

