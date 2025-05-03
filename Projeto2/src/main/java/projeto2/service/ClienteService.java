package projeto2.service;

import projeto2.DAO.IGenericDAO;
import projeto2.domain.Cliente;

public class ClienteService extends GenericService<Cliente> implements IClienteService {
	public ClienteService(IGenericDAO<Cliente> dao) {
        super(dao);
    }
}
