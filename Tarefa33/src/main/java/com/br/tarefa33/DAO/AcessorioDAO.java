package com.br.tarefa33.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.tarefa33.domain.Acessorio;

@Repository
public interface AcessorioDAO extends JpaRepository<Acessorio, Long> {
}
