package com.br.tarefa33.service;

import org.springframework.stereotype.Service;
import com.br.tarefa33.DAO.CarroDAO;
import com.br.tarefa33.domain.Carro;

import java.util.List;

@Service
public class CarroService {

    private final CarroDAO repository;

    public CarroService(CarroDAO repository) {
        this.repository = repository;
    }

    public List<Carro> listarTodos() {
        return repository.findAll();
    }

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }

    public Carro buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
