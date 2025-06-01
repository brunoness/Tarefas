package service;

import DAO.IClienteDAO;
import domain.Cliente;

import java.util.Collection;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente cadastrar(Cliente entity) {
        return clienteDAO.cadastrar(entity);
    }

    @Override
    public void excluir(Cliente entity) {
        clienteDAO.excluir(entity);
    }

    @Override
    public Cliente alterar(Cliente entity) {
        return clienteDAO.alterar(entity);
    }

    @Override
    public Cliente consultar(Long id) {
        return clienteDAO.consultar(id);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return clienteDAO.buscarTodos();
    }
}

