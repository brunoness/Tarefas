package projeto2.service;

import projeto2.DAO.ClienteDAO;
import projeto2.domain.Cliente;

public class ClienteService extends GenericService<Cliente> implements IClienteService {
	public ClienteService(ClienteDAO clienteDAO) {
        super(new ClienteDAO());
    }
}
