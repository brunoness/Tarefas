package service;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService<T extends Serializable, E extends Serializable> {

    public T cadastrar(T entity);

    public void excluir(T entity);

    public T alterar(T entity);

    public T consultar(E id);

    public Collection<T> buscarTodos();
}

