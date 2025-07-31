package com.bruno.tarefa42.repository;

import com.bruno.tarefa42.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
