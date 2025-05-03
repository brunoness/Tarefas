package projeto2.service;

public interface IGenericService<T> {
	
	void salvar(T entity);
	
    T buscar(Long id);
    
    void excluir(Long id);
    
    void atualizar(T entity);

}
