package projeto2.service;

import java.util.List;

public interface IGenericService<T> {
	
	boolean cadastrar(T entidade);

    void excluir(Long id);

    void alterar(T entidade);

    T consultar(Long id);

    List<T> buscarTodos();

}
