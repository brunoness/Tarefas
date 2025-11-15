package br.com.tarefa48.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tarefa48.entidades.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	@Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL AND a.obito IS NULL ORDER BY a.dataEntrada")
	List<Animal> findNotAdopted();
	
	@Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL AND a.obito IS NULL ORDER BY a.dataEntrada")
	List<Animal> findAdopted();
	
	@Query("SELECT a FROM Animal a WHERE a.obito IS NOT NULL ORDER BY a.dataEntrada")
	List<Animal> findObito();

}
