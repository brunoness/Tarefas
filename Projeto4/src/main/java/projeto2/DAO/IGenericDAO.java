package projeto2.DAO;

import java.util.List;

public interface IGenericDAO<T> {

    Boolean cadastrar(T entidade);
    
    void excluir(Long codigo);
    
    void alterar(T entidade);
    
    T consultar(Long codigo);
    
    List<T> buscarTodos();
}
