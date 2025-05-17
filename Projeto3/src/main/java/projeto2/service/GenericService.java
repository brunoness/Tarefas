package projeto2.service;

import java.util.List;

import projeto2.DAO.IGenericDAO;

public abstract class GenericService<T> implements IGenericService<T> {
	protected IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public boolean cadastrar(T entidade) {
        return dao.cadastrar(entidade);
    }

    @Override
    public void excluir(Long id) {
        dao.excluir(id);
    }

    @Override
    public void alterar(T entidade) {
        dao.alterar(entidade);
    }

    @Override
    public T consultar(Long id) {
        return dao.consultar(id);
    }

    @Override
    public List<T> buscarTodos() {
        return dao.buscarTodos();
    }
}
