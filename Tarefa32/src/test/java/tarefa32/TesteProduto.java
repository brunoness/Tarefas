package tarefa32;

import static org.junit.Assert.assertNotNull;

import org.junit.*;

import tarefa32.dao.IProdutoDAO;
import tarefa32.dao.ProdutoDAO;
import tarefa32.domain.Produto;

public class TesteProduto {
	
	private IProdutoDAO produtoDAO;
	
	public TesteProduto() {
		produtoDAO = new ProdutoDAO();
	}

	@Test
	public void cadastrar() {
		Produto produto = new Produto();
		produto.setNome("Beterraba");
		produto.setPreco(200);
		produto = produtoDAO.cadastrar(produto);
		
		assertNotNull(produto);
		assertNotNull(produto.getId());
		
	}
}
