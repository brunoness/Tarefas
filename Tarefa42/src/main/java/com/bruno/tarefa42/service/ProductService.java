package com.bruno.tarefa42.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.tarefa42.model.Product;
import com.bruno.tarefa42.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
    private ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> existing = repository.findById(id);
        if (existing.isPresent()) {
            product.setId(id);
            return repository.save(product);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
