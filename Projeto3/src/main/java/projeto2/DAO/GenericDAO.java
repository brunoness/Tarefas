package projeto2.DAO;

import java.sql.*;
import java.util.*;

import projeto2.DAO.jdbc.*;
import projeto2.domain.Persistente;

public class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

	protected Connection connection;

    public GenericDAO() {
    	this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Boolean cadastrar(T entidade) {
        throw new UnsupportedOperationException("Não implementado");
    }

    @Override
    public void excluir(Long codigo) {
        throw new UnsupportedOperationException("Não implementado");
    }

    @Override
    public void alterar(T entidade) {
        throw new UnsupportedOperationException("Não implementado");
    }

    @Override
    public T consultar(Long codigo) {
        throw new UnsupportedOperationException("Não implementado");
    }

    @Override
    public List<T> buscarTodos() {
        throw new UnsupportedOperationException("Não implementado");
    }

    
}
