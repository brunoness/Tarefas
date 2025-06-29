package DAO;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Serializable, E extends Serializable> {

    public T cadastrar(T entity, String dbName);

    public void excluir(T entity, String dbName);

    public T alterar(T entity, String dbName);

    public T consultar(E id, String dbName);

    public Collection<T> buscarTodos(String dbName);


}

