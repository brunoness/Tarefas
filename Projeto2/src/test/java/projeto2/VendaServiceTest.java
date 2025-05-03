package projeto2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto2.domain.Cliente;
import projeto2.domain.Produto;
import projeto2.domain.Venda;
import projeto2.service.IVendaService;
import projeto2.service.VendaService;
import projeto2.DAO.GenericDAOMock;

import java.util.Arrays;

public class VendaServiceTest {

    private IVendaService vendaService;

    @Before
    public void setUp() {
        vendaService = new VendaService(new GenericDAOMock<>());
    }

    @Test
    public void deveSalvarVendaComSucesso() {
        Cliente cliente = new Cliente(1L, "Carlos", 1234);
        Produto p1 = new Produto(1L, "Notebook", 2500.0);
        Produto p2 = new Produto(2L, "Mouse", 50.0);
        Venda venda = new Venda(1L, cliente, Arrays.asList(p1, p2));

        vendaService.salvar(venda);
        Venda resultado = vendaService.buscar(1L);

        Assert.assertNotNull(resultado);
        Assert.assertEquals(2, resultado.getProdutos().size());
    }

    @Test
    public void deveCalcularTotalDaVenda() {
        Cliente cliente = new Cliente(2L, "Ana", 568);
        Produto p1 = new Produto(1L, "Cadeira", 300.0);
        Produto p2 = new Produto(2L, "Mesa", 500.0);
        Venda venda = new Venda(2L, cliente, Arrays.asList(p1, p2));

        vendaService.salvar(venda);
        double total = vendaService.calcularTotal(2L);

        Assert.assertEquals(800.0, total, 0.001);
    }

    @Test
    public void deveRetornarZeroParaVendaSemProdutos() {
        Cliente cliente = new Cliente(3L, "Lucas", 9876);
        Venda venda = new Venda(3L, cliente, Arrays.asList());

        vendaService.salvar(venda);
        double total = vendaService.calcularTotal(3L);

        Assert.assertEquals(0.0, total, 0.001);
    }
}