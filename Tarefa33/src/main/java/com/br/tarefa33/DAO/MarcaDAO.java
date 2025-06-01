package com.br.tarefa33.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;
import com.br.tarefa33.domain.Marca;

@Repository
public interface MarcaDAO extends JpaRepository<Marca, Long> {
}
