

import DAO.*;
import domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class VendaDAOTest {

    private IVendaDAO vendaDao;
    private IClienteDAO clienteDao;
    private IProdutoDAO produtoDao;
    private Random rd;
    private Cliente cliente;
    private Produto produto1;
    private Produto produto2;

    public VendaDAOTest() {
        vendaDao = new VendaDAO();
        clienteDao = new ClienteDAO();
        produtoDao = new ProdutoDAO();
        rd = new Random();
    }

    @Before
    public void init() {
        cleanupTestData();

        cliente = createCliente();
        clienteDao.cadastrar(cliente);

        produto1 = createProduto("P1");
        produtoDao.cadastrar(produto1);

        produto2 = createProduto("P2");
        produtoDao.cadastrar(produto2);
    }

    @After
    public void end() {
        cleanupTestData();
    }

    private void cleanupTestData() {
        Collection<Venda> vendas = vendaDao.buscarTodos();
        for (Venda venda : vendas) {
            try {
                Venda vendaToDelete = vendaDao.consultarComCollection(venda.getId());
                if (vendaToDelete != null) {
                    vendaToDelete.getProdutos().clear();
                    vendaDao.excluir(vendaToDelete);
                }
            } catch (Exception e) {
            	
            }
        }


        Collection<Produto> produtos = produtoDao.buscarTodos();
        produtos.forEach(prod -> {
            try {
                produtoDao.excluir(prod);
            } catch (Exception e) { 
            
            }
        });

        Collection<Cliente> clientes = clienteDao.buscarTodos();
        clientes.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (Exception e) {
            
            }
        });
    }

    @Test
    public void cadastrarVenda() {
        Venda venda = createVenda();
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);
        assertNotNull(vendaCadastrada.getId());
        assertEquals(Venda.Status.INICIADA, vendaCadastrada.getStatus());
        assertEquals(cliente.getId(), vendaCadastrada.getCliente().getId());

        Venda vendaConsultada = vendaDao.consultarComCollection(vendaCadastrada.getId());
        assertNotNull(vendaConsultada);
        assertEquals(1, vendaConsultada.getProdutos().size());
        ProdutoQuantidade pq = vendaConsultada.getProdutos().iterator().next();
        assertEquals(produto1.getId(), pq.getProduto().getId());
        assertEquals(Integer.valueOf(2), pq.getQuantidade());
        assertEquals(0, produto1.getPreco().multiply(BigDecimal.valueOf(2)).compareTo(pq.getValorTotal()));
        assertEquals(0, pq.getValorTotal().compareTo(vendaConsultada.getValorTotal()));
    }

    @Test
    public void consultarVenda() {
        Venda venda = createVenda();
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);

        Venda vendaConsultada = vendaDao.consultar(vendaCadastrada.getId());
        assertNotNull(vendaConsultada);
        assertEquals(vendaCadastrada.getId(), vendaConsultada.getId());
        assertEquals(vendaCadastrada.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void consultarVendaComCollection() {
        Venda venda = createVenda();
        venda.adicionarProduto(produto2, 3);
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);

        Venda vendaConsultada = vendaDao.consultarComCollection(vendaCadastrada.getId());
        assertNotNull(vendaConsultada);
        assertNotNull(vendaConsultada.getCliente());
        assertNotNull(vendaConsultada.getProdutos());
        assertEquals(2, vendaConsultada.getProdutos().size());
        assertEquals(cliente.getId(), vendaConsultada.getCliente().getId());

        BigDecimal totalExpected = produto1.getPreco().multiply(BigDecimal.valueOf(2))
                                      .add(produto2.getPreco().multiply(BigDecimal.valueOf(3)));
        assertEquals(0, totalExpected.compareTo(vendaConsultada.getValorTotal()));
    }

    @Test
    public void excluirVenda() {
        Venda venda = createVenda();
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);

        Venda vendaParaExcluir = vendaDao.consultarComCollection(vendaCadastrada.getId());
        vendaDao.excluir(vendaParaExcluir);

        Venda vendaConsultada = vendaDao.consultar(vendaCadastrada.getId());
        assertNull(vendaConsultada);
    }

    @Test
    public void alterarVendaAdicionarProduto() {
        Venda venda = createVenda();
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);
        assertEquals(1, vendaCadastrada.getProdutos().size());
        assertEquals(0, produto1.getPreco().multiply(BigDecimal.valueOf(2)).compareTo(vendaCadastrada.getValorTotal()));

        vendaCadastrada.adicionarProduto(produto2, 1);
        Venda vendaAlterada = vendaDao.alterar(vendaCadastrada);
        assertNotNull(vendaAlterada);

        Venda vendaConsultada = vendaDao.consultarComCollection(vendaAlterada.getId());
        assertNotNull(vendaConsultada);
        assertEquals(2, vendaConsultada.getProdutos().size());
        BigDecimal totalExpected = produto1.getPreco().multiply(BigDecimal.valueOf(2))
                                      .add(produto2.getPreco().multiply(BigDecimal.valueOf(1)));
        assertEquals(0, totalExpected.compareTo(vendaConsultada.getValorTotal()));
    }

     @Test
    public void alterarVendaRemoverProduto() {
        Venda venda = createVenda();
        venda.adicionarProduto(produto2, 3);
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);
        assertEquals(2, vendaCadastrada.getProdutos().size());

        vendaCadastrada.removerProduto(produto1, 2);
        Venda vendaAlterada = vendaDao.alterar(vendaCadastrada);
        assertNotNull(vendaAlterada);

        Venda vendaConsultada = vendaDao.consultarComCollection(vendaAlterada.getId());
        assertNotNull(vendaConsultada);
        assertEquals(1, vendaConsultada.getProdutos().size());
        ProdutoQuantidade pq = vendaConsultada.getProdutos().iterator().next();
        assertEquals(produto2.getId(), pq.getProduto().getId());
        assertEquals(Integer.valueOf(3), pq.getQuantidade());
        assertEquals(0, produto2.getPreco().multiply(BigDecimal.valueOf(3)).compareTo(vendaConsultada.getValorTotal()));
    }

    @Test
    public void finalizarVenda() {
        Venda venda = createVenda();
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);
        assertEquals(Venda.Status.INICIADA, vendaCadastrada.getStatus());

        vendaCadastrada.setStatus(Venda.Status.CONCLUIDA);
        vendaDao.finalizarVenda(vendaCadastrada);

        Venda vendaConsultada = vendaDao.consultar(vendaCadastrada.getId());
        assertNotNull(vendaConsultada);
        assertEquals(Venda.Status.CONCLUIDA, vendaConsultada.getStatus());
    }

    @Test
    public void cancelarVenda() {
        Venda venda = createVenda();
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        assertNotNull(vendaCadastrada);
        assertEquals(Venda.Status.INICIADA, vendaCadastrada.getStatus());

        vendaCadastrada.setStatus(Venda.Status.CANCELADA);
        vendaDao.cancelarVenda(vendaCadastrada);

        Venda vendaConsultada = vendaDao.consultar(vendaCadastrada.getId());
        assertNotNull(vendaConsultada);
        assertEquals(Venda.Status.CANCELADA, vendaConsultada.getStatus());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tentarAdicionarProdutoVendaFinalizada() {
        Venda venda = createVenda();
        Venda vendaCadastrada = vendaDao.cadastrar(venda);
        vendaCadastrada.setStatus(Venda.Status.CONCLUIDA);
        vendaDao.finalizarVenda(vendaCadastrada);

        Venda vendaFinalizada = vendaDao.consultarComCollection(vendaCadastrada.getId());
        vendaFinalizada.adicionarProduto(produto2, 1);
    }

    private Venda createVenda() {
        Venda venda = new Venda();
        venda.setCodigo("V" + rd.nextInt(10000));
        venda.setDataVenda(Instant.now());
        venda.setCliente(cliente);
        venda.setStatus(Venda.Status.INICIADA);
        venda.adicionarProduto(produto1, 2); 
        return venda;
    }

    private Cliente createCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Teste Cliente Venda");
        cliente.setCidade("Teste Cidade");
        cliente.setEndereco("Teste End");
        cliente.setEstado("TS");
        cliente.setNumero(10);
        cliente.setTelefone(11999999999L);
        return cliente;
    }

    private Produto createProduto(String suffix) {
        Produto produto = new Produto();
        produto.setCodigo("P" + suffix + rd.nextInt(1000));
        produto.setNome("Produto Teste " + suffix);
        produto.setDescricao("Descrição Teste " + suffix);
        produto.setPreco(BigDecimal.valueOf(rd.nextDouble() * 100 + 10).setScale(2, BigDecimal.ROUND_HALF_UP));
        return produto;
    }
}

