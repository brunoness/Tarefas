package projeto2.service;

import projeto2.DAO.EstoqueDAO;
import projeto2.DAO.VendaDAO;
import projeto2.domain.Estoque;
import projeto2.domain.Produto;
import projeto2.domain.Venda;

public class VendaService extends GenericService<Venda> implements IVendaService {

	public VendaService(VendaDAO vendaDAO) {
        super(new VendaDAO());
    }
	
	private EstoqueDAO estoqueDAO = new EstoqueDAO();
	
	 @Override
	    public boolean cadastrar(Venda venda) {
	        for (Produto produto : venda.getProdutos()) {
	            Estoque estoque = estoqueDAO.consultar(produto.getId());
	            if (estoque == null) {
	                throw new RuntimeException("Produto sem estoque: " + produto.getNome());
	            }
	            if (estoque.getQuantidade() <= 0) {
	                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
	            }
	            estoque.diminuir(1);
	            estoqueDAO.alterar(estoque);
	        }
	        return super.cadastrar(venda);
	    }

}
