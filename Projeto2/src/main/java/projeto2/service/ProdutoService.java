package projeto2.service;

import projeto2.DAO.IGenericDAO;
import projeto2.domain.Produto;

public class ProdutoService extends GenericService<Produto> implements IProdutoService {

    public ProdutoService(IGenericDAO<Produto> dao) {
        super(dao);
    }
}
