package service;

import model.Cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    @PersistenceContext(unitName = "mod38PU")
    private EntityManager em;

    @Transactional
    public void salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            em.persist(cliente);
        } else {
            em.merge(cliente);
        }
    }

    public List<Cliente> listarTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
}
