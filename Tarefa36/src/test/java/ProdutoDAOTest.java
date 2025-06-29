
import DAO.ProdutoDAO;
import domain.Produto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class ProdutoDAOTest {
	private ProdutoDAO produtoDAO;
	private final String DB_NAME = "mod36";

	@Before
	public void setUp() {
		produtoDAO = new ProdutoDAO();
	}

	@Test
	public void testCadastrarConsultarProduto() {
		Produto produto = new Produto();
		produto.setCodigo("PROD001");
		produto.setNome("Produto Teste 1");
		produto.setDescricao("Descrição do Produto Teste 1");
		produto.setPreco(new BigDecimal("100.50"));
		Produto produtoCadastrado = produtoDAO.cadastrar(produto, DB_NAME);
		assertNotNull(produtoCadastrado);
		assertNotNull(produtoCadastrado.getId());
		Produto produtoConsultado = produtoDAO.consultar(produtoCadastrado.getId(), DB_NAME);
		assertNotNull(produtoConsultado);
		assertEquals(produto.getCodigo(), produtoConsultado.getCodigo());
		assertEquals(produto.getNome(), produtoConsultado.getNome());
	}

	@Test
	public void testAlterarProduto() {
		Produto produto = new Produto();
		produto.setCodigo("PROD002");
		produto.setNome("Produto Original");
		produto.setDescricao("Descrição Original");
		produto.setPreco(new BigDecimal("250.00"));
		Produto produtoCadastrado = produtoDAO.cadastrar(produto, DB_NAME);
		assertNotNull(produtoCadastrado);
		produtoCadastrado.setNome("Produto Alterado");
		produtoCadastrado.setDescricao("Descrição Alterada");
		produtoCadastrado.setPreco(new BigDecimal("275.99"));
		Produto produtoAlterado = produtoDAO.alterar(produtoCadastrado, DB_NAME);
		assertNotNull(produtoAlterado);
		assertEquals("Produto Alterado", produtoAlterado.getNome());
		assertEquals("Descrição Alterada", produtoAlterado.getDescricao());
		assertEquals(new BigDecimal("275.99"), produtoAlterado.getPreco());
	}

	@Test
	public void testExcluirProduto() {
		Produto produto = new Produto();
		produto.setCodigo("PROD003");
		produto.setNome("Produto a Excluir");
		produto.setDescricao("Descrição a Excluir");
		produto.setPreco(new BigDecimal("50.00"));
		Produto produtoCadastrado = produtoDAO.cadastrar(produto, DB_NAME);
		assertNotNull(produtoCadastrado);
		assertNotNull(produtoCadastrado.getId());
		produtoDAO.excluir(produtoCadastrado, DB_NAME);
		Produto produtoConsultado = produtoDAO.consultar(produtoCadastrado.getId(), DB_NAME);
		assertNull(produtoConsultado);
	}
}

//
//import DAO.IProdutoDAO;
//import DAO.ProdutoDAO;
//import domain.Produto;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.util.Collection;
//import java.util.Random;
//
//import static org.junit.Assert.*;
//
//public class ProdutoDAOTest {
//
//    private IProdutoDAO produtoDao;
//    private Random rd;
//
//    public ProdutoDAOTest() {
//        produtoDao = new ProdutoDAO();
//        rd = new Random();
//    }
//
//    @Before
//    public void init() {
//        Collection<Produto> list = produtoDao.buscarTodos();
//        list.forEach(prod -> {
//            try {
//                produtoDao.excluir(prod);
//            } catch (Exception e) {
//         
//            }
//        });
//    }
//
//    @After
//    public void end() {
//        Collection<Produto> list = produtoDao.buscarTodos();
//        list.forEach(prod -> {
//            try {
//                produtoDao.excluir(prod);
//            } catch (Exception e) {
//               
//            }
//        });
//    }
//
//    @Test
//    public void pesquisarProduto() {
//        Produto produto = createProduto();
//        produtoDao.cadastrar(produto);
//
//        Produto produtoConsultado = produtoDao.consultar(produto.getId());
//        assertNotNull(produtoConsultado);
//        assertEquals(produto.getCodigo(), produtoConsultado.getCodigo());
//        assertEquals(produto.getNome(), produtoConsultado.getNome());
//        assertEquals(0, produto.getPreco().compareTo(produtoConsultado.getPreco()));
//    }
//
//    @Test
//    public void salvarProduto() {
//        Produto produto = createProduto();
//        Produto produtoSalvo = produtoDao.cadastrar(produto);
//        assertNotNull(produtoSalvo);
//        assertNotNull(produtoSalvo.getId());
//    }
//
//    @Test
//    public void excluirProduto() {
//        Produto produto = createProduto();
//        Produto produtoSalvo = produtoDao.cadastrar(produto);
//        assertNotNull(produtoSalvo);
//
//        produtoDao.excluir(produtoSalvo);
//        Produto produtoConsultado = produtoDao.consultar(produtoSalvo.getId());
//        assertNull(produtoConsultado);
//    }
//
//    @Test
//    public void alterarProduto() {
//        Produto produto = createProduto();
//        Produto produtoSalvo = produtoDao.cadastrar(produto);
//        assertNotNull(produtoSalvo);
//
//        produtoSalvo.setNome("Produto Alterado");
//        produtoSalvo.setPreco(BigDecimal.valueOf(150.99));
//        Produto produtoAlterado = produtoDao.alterar(produtoSalvo);
//        assertNotNull(produtoAlterado);
//        assertEquals("Produto Alterado", produtoAlterado.getNome());
//        assertEquals(0, BigDecimal.valueOf(150.99).compareTo(produtoAlterado.getPreco()));
//
//        Produto produtoConsultado = produtoDao.consultar(produtoAlterado.getId());
//        assertNotNull(produtoConsultado);
//        assertEquals("Produto Alterado", produtoConsultado.getNome());
//        assertEquals(0, BigDecimal.valueOf(150.99).compareTo(produtoConsultado.getPreco()));
//    }
//
//    @Test
//    public void buscarTodos() {
//        Produto produto1 = createProduto();
//        produtoDao.cadastrar(produto1);
//
//        Produto produto2 = createProduto();
//        produtoDao.cadastrar(produto2);
//
//        Collection<Produto> list = produtoDao.buscarTodos();
//        assertNotNull(list);
//        assertEquals(2, list.size());
//    }
//
//    private Produto createProduto() {
//        Produto produto = new Produto();
//        produto.setCodigo("P" + rd.nextInt(10000));
//        produto.setNome("Produto Teste");
//        produto.setDescricao("Descrição do Produto Teste");
//        produto.setPreco(BigDecimal.valueOf(rd.nextDouble() * 100).setScale(2, BigDecimal.ROUND_HALF_UP));
//        return produto;
//    }
//}
