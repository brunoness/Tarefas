package service;

import DAO.IClienteDAO;
import domain.Cliente;

import java.util.Collection;

public abstract class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente cadastrar(Cliente entity, String dbName) {
        return clienteDAO.cadastrar(entity, dbName);
    }

    @Override
    public void excluir(Cliente entity, String dbName) {
        clienteDAO.excluir(entity, dbName);
    }

    @Override
    public Cliente alterar(Cliente entity, String dbName) {
        return clienteDAO.alterar(entity, dbName);
    }

    @Override
    public Cliente consultar(Long id, String dbName) {
        return clienteDAO.consultar(id, dbName);
    }

    @Override
    public Collection<Cliente> buscarTodos(String dbName) {
        return clienteDAO.buscarTodos(dbName);
    }

	@Override
	public Cliente cadastrar(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}
}

