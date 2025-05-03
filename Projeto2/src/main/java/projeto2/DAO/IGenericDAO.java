package projeto2.DAO;

public interface IGenericDAO<T> {
	
    void salvar(T entity);
    
    T buscar(Long id);
    
    void excluir(Long id);
    
    void atualizar(T entity);
}
