package com.bruno.tarefa42.service;

import java.util.List;
import com.bruno.tarefa42.model.Sale;

public interface ISaleService {
	Sale makeSale(Long clientId, List<Long> productIds);
    Sale findById(Long id);
    List<Sale> findAll();
}
