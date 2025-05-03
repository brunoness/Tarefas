package projeto2.DAO;

import java.util.HashMap;
import java.util.Map;

public class GenericDAOMock<T> implements IGenericDAO<T> {
	private Map<Long, T> store = new HashMap<>();

    @Override
    public void salvar(T entity) {
        try {
            Long id = (Long) entity.getClass().getMethod("getId").invoke(entity);
            store.put(id, entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar entidade", e);
        }
    }

    @Override
    public T buscar(Long id) {
        return store.get(id);
    }

    @Override
    public void excluir(Long id) {
        store.remove(id);
    }

    @Override
    public void atualizar(T entity) {
        salvar(entity);
    }
}
