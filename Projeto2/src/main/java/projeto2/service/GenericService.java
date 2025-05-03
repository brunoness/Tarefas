package projeto2.service;

import projeto2.DAO.IGenericDAO;

public abstract class GenericService<T> implements IGenericService<T> {
	protected IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }

    public void salvar(T entity) {
        dao.salvar(entity);
    }

    public T buscar(Long id) {
        return dao.buscar(id);
    }

    public void excluir(Long id) {
        dao.excluir(id);
    }

    public void atualizar(T entity) {
        dao.atualizar(entity);
    }
}
