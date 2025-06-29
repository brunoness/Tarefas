package service;

import java.util.Collection;

import domain.Cliente;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente cadastrar(Cliente entity, String dbName);

	void excluir(Cliente entity, String dbName);

	Cliente alterar(Cliente entity, String dbName);

	Cliente consultar(Long id, String dbName);

	Collection<Cliente> buscarTodos(String dbName);

}

