package projeto2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto2.domain.Produto;
import projeto2.service.IProdutoService;
import projeto2.service.ProdutoService;
import projeto2.DAO.GenericDAOMock;

public class ProdutoServiceTest {
	
	private IProdutoService produtoService;

    @Before
    public void setUp() {
        produtoService = new ProdutoService(new GenericDAOMock<>());
    }

    @Test
    public void deveSalvarProduto() {
        Produto produto = new Produto(1L, "Mouse", 59.90);
        produtoService.salvar(produto);

        Produto resultado = produtoService.buscar(1L);
        Assert.assertNotNull(resultado);
        Assert.assertEquals("Mouse", resultado.getNome());
    }

    @Test
    public void deveAtualizarProduto() {
        Produto produto = new Produto(1L, "Mouse", 59.90);
        produtoService.salvar(produto);

        produto.setPreco(79.90);
        produtoService.atualizar(produto);

        Produto atualizado = produtoService.buscar(1L);
        Assert.assertEquals(Double.valueOf(79.90), atualizado.getPreco());
    }

    @Test
    public void deveExcluirProduto() {
        Produto produto = new Produto(2L, "Teclado", 89.90);
        produtoService.salvar(produto);

        produtoService.excluir(2L);
        Produto resultado = produtoService.buscar(2L);

        Assert.assertNull(resultado);
    }
}
