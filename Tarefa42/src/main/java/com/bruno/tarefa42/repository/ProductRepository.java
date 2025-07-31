package com.bruno.tarefa42.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bruno.tarefa42.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
