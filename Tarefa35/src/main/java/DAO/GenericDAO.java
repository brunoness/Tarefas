package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @param <T> Classe de domínio
 * @param <E> Tipo da chave primária
 */
public abstract class GenericDAO<T extends Serializable, E extends Serializable> implements IGenericDAO<T, E> {

    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    protected Class<T> persistenteClass;

    public GenericDAO(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            entityManagerFactory = Persistence.createEntityManagerFactory("tarefa35PU");
        }
    }

    @Override
    public T cadastrar(T entity) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    @Override
    public void excluir(T entity) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity); // Ensure entity is managed before removal
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T alterar(T entity) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    @Override
    public T consultar(E id) {
        entityManager = entityManagerFactory.createEntityManager();
        T entity = entityManager.find(this.persistenteClass, id);
        entityManager.close();
        return entity;
    }

    @Override
    public Collection<T> buscarTodos() {
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.persistenteClass);
        Root<T> root = query.from(this.persistenteClass);
        query.select(root);
        TypedQuery<T> tpQuery = entityManager.createQuery(query);
        List<T> list = tpQuery.getResultList();
        entityManager.close();
        return list;
    }
}

