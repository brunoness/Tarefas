package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
public class PersistenceManager {
	private static PersistenceManager instance;
	private Map<String, EntityManagerFactory> emfMap;
	
	private PersistenceManager() {
		emfMap = new HashMap<>();
		emfMap.put("mod35",
				Persistence.createEntityManagerFactory("tarefa35PU"));
		emfMap.put("mod36",
				Persistence.createEntityManagerFactory("tarefa36PU"));
	}
	
	public static synchronized PersistenceManager getInstance() {
		if (instance == null) {
			instance = new PersistenceManager();
		}
		return instance;
	}
	
	public EntityManager getEntityManager(String dbName) {
		EntityManagerFactory emf = emfMap.get(dbName);
		if (emf != null) {
			return emf.createEntityManager();
		}
		throw new IllegalArgumentException("No persistence unit found for database: " + dbName);
	}
	
	public void close() {
		for (EntityManagerFactory emf : emfMap.values()) {
			if (emf.isOpen()) {
				emf.close();
			}
		}
	}
}
