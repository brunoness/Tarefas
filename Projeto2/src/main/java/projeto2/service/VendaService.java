package projeto2.service;

import projeto2.DAO.IGenericDAO;
import projeto2.domain.Venda;

public class VendaService extends GenericService<Venda> implements IVendaService {

    public VendaService(IGenericDAO<Venda> dao) {
        super(dao);
    }
    
    @Override
    public double calcularTotal(Long idVenda) {
        Venda venda = dao.buscar(idVenda);
        if (venda == null || venda.getProdutos() == null || venda.getProdutos().isEmpty()) {
            return 0.0;
        }
        return venda.getTotal();
    }
}
