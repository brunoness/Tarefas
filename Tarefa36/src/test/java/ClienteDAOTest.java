
import DAO.ClienteDAO;
import domain.Cliente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteDAOTest {
	private ClienteDAO clienteDAO;
	private final String DB_NAME = "mod35";

	@Before
	public void setUp() {
		clienteDAO = new ClienteDAO();
	}
	
	

	@Test
	public void testCadastrarConsultarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf(12345678901L);
		cliente.setNome("Teste Cliente 1");
		cliente.setEndereco("Rua Teste");
		cliente.setNumero(123);
		cliente.setCidade("Cidade Teste");
		cliente.setEstado("TS");
		cliente.setTelefone(987654321L);
		Cliente clienteCadastrado = clienteDAO.cadastrar(cliente, DB_NAME);
		assertNotNull(clienteCadastrado);
		assertNotNull(clienteCadastrado.getId());
		Cliente clienteConsultado = clienteDAO.consultar(clienteCadastrado.getId(), DB_NAME);
		assertNotNull(clienteConsultado);
		assertEquals(cliente.getCpf(), clienteConsultado.getCpf());
		assertEquals(cliente.getNome(), clienteConsultado.getNome());
	}

	@Test
	public void testAlterarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf(11223344556L);
		cliente.setNome("Cliente Original");
		cliente.setEndereco("End Original");
		cliente.setNumero(1234);
		cliente.setCidade("Cidade Original");
		cliente.setEstado("OR");
		cliente.setTelefone(111222333L);
		Cliente clienteCadastrado = clienteDAO.cadastrar(cliente, DB_NAME);
		assertNotNull(clienteCadastrado);
		clienteCadastrado.setNome("Cliente Alterado");
		clienteCadastrado.setEndereco("End Alterado");
		Cliente clienteAlterado = clienteDAO.alterar(clienteCadastrado, DB_NAME);
		assertNotNull(clienteAlterado);
		assertEquals("Cliente Alterado", clienteAlterado.getNome());
		assertEquals("End Alterado", clienteAlterado.getEndereco());
	}

	@Test
	public void testExcluirCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf(99887766554L);
		cliente.setNome("Cliente a Excluir");
		cliente.setEndereco("End Excluir");
		cliente.setNumero(1234);
		cliente.setCidade("Cidade Excluir");
		cliente.setEstado("EX");
		cliente.setTelefone(445566778L);
		Cliente clienteCadastrado = clienteDAO.cadastrar(cliente, DB_NAME);
		assertNotNull(clienteCadastrado);
		assertNotNull(clienteCadastrado.getId());
		clienteDAO.excluir(clienteCadastrado, DB_NAME);
		Cliente clienteConsultado = clienteDAO.consultar(clienteCadastrado.getId(), DB_NAME);
		assertNull(clienteConsultado);
	}
}

//import DAO.ClienteDAO;
//import DAO.IClienteDAO;
//import domain.Cliente;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Collection;
//import java.util.Random;
//
//import static org.junit.Assert.*;
//
//public class ClienteDAOTest {
//
//    private IClienteDAO clienteDao;
//    private Random rd;
//
//    public ClienteDAOTest() {
//        clienteDao = new ClienteDAO();
//        rd = new Random();
//    }
//
//    @Before
//    public void init() {
//        Collection<Cliente> list = clienteDao.buscarTodos();
//        list.forEach(cli -> {
//            try {
//                clienteDao.excluir(cli);
//            } catch (Exception e) {
//            	
//            }
//        });
//    }
//
//    @After
//    public void end() {
//        Collection<Cliente> list = clienteDao.buscarTodos();
//        list.forEach(cli -> {
//            try {
//                clienteDao.excluir(cli);
//            } catch (Exception e) {
//            	
//            }
//        });
//    }
//
//    @Test
//    public void pesquisarCliente() {
//        Cliente cliente = createCliente();
//        clienteDao.cadastrar(cliente);
//
//        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
//        assertNotNull(clienteConsultado);
//        assertEquals(cliente.getNome(), clienteConsultado.getNome());
//        assertEquals(cliente.getCpf(), clienteConsultado.getCpf());
//    }
//
//    @Test
//    public void salvarCliente() {
//        Cliente cliente = createCliente();
//        Cliente clienteSalvo = clienteDao.cadastrar(cliente);
//        assertNotNull(clienteSalvo);
//        assertNotNull(clienteSalvo.getId());
//    }
//
//
//    @Test
//    public void excluirCliente() {
//        Cliente cliente = createCliente();
//        Cliente clienteSalvo = clienteDao.cadastrar(cliente);
//        assertNotNull(clienteSalvo);
//
//        clienteDao.excluir(clienteSalvo);
//        Cliente clienteConsultado = clienteDao.consultar(clienteSalvo.getId());
//        assertNull(clienteConsultado);
//    }
//
//    @Test
//    public void alterarCliente() {
//        Cliente cliente = createCliente();
//        Cliente clienteSalvo = clienteDao.cadastrar(cliente);
//        assertNotNull(clienteSalvo);
//
//        clienteSalvo.setNome("Nome Alterado");
//        Cliente clienteAlterado = clienteDao.alterar(clienteSalvo);
//        assertNotNull(clienteAlterado);
//        assertEquals("Nome Alterado", clienteAlterado.getNome());
//
//        Cliente clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
//        assertNotNull(clienteConsultado);
//        assertEquals("Nome Alterado", clienteConsultado.getNome());
//    }
//
//    @Test
//    public void buscarTodos() {
//        Cliente cliente1 = createCliente();
//        clienteDao.cadastrar(cliente1);
//
//        Cliente cliente2 = createCliente();
//        clienteDao.cadastrar(cliente2);
//
//        Collection<Cliente> list = clienteDao.buscarTodos();
//        assertNotNull(list);
//        assertEquals(2, list.size());
//
//    }
//
//    private Cliente createCliente() {
//        Cliente cliente = new Cliente();
//        cliente.setCpf(rd.nextLong());
//        cliente.setNome("Teste Cliente");
//        cliente.setCidade("Teste Cidade");
//        cliente.setEndereco("Teste End");
//        cliente.setEstado("TS");
//        cliente.setNumero(10);
//        cliente.setTelefone(11999999999L);
//        return cliente;
//    }
//}
//
