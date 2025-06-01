package com.br.tarefa33.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.tarefa33.domain.Carro;

@Repository
public interface CarroDAO extends JpaRepository<Carro, Long> {
}