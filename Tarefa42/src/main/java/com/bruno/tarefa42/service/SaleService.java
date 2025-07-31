package com.bruno.tarefa42.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.tarefa42.model.*;
import com.bruno.tarefa42.repository.*;

@Service
public class SaleService implements ISaleService {
	
	@Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Sale makeSale(Long clientId, List<Long> productIds) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if (clientOpt.isEmpty()) return null;

        List<Product> products = productRepository.findAllById(productIds);
        if (products.size() != productIds.size()) return null;

        double total = 0.0;
        for (Product p : products) {
            if (p.getQuantity() <= 0) return null; // no stock
            p.setQuantity(p.getQuantity() - 1); // decrement stock
            total += p.getPrice();
        }

        Sale sale = new Sale();
        sale.setClient(clientOpt.get());
        sale.setProducts(products);
        sale.setTotal(total);
        sale.setDate(LocalDateTime.now());

        productRepository.saveAll(products); // save stock updates
        return saleRepository.save(sale);
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

}
