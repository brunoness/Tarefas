package projeto2.service;

import projeto2.DAO.ProdutoDAO;
import projeto2.domain.Produto;

public class ProdutoService extends GenericService<Produto> implements IProdutoService {

	public ProdutoService(ProdutoDAO produtoDAO) {
        super(new ProdutoDAO());
    }
}
