package projeto2.service;

import projeto2.DAO.VendaDAO;
import projeto2.domain.Venda;

public class VendaService extends GenericService<Venda> implements IVendaService {

	public VendaService(VendaDAO vendaDAO) {
        super(new VendaDAO());
    }

}
