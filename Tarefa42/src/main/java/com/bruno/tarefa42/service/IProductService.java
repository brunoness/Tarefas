package com.bruno.tarefa42.service;

import java.util.List;
import com.bruno.tarefa42.model.Product;

public interface IProductService {
	Product save(Product product);
    Product findById(Long id);
    List<Product> findAll();
    Product update(Long id, Product product);
    void delete(Long id);

}
