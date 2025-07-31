package com.bruno.tarefa42.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.tarefa42.model.Client;
import com.bruno.tarefa42.repository.ClientRepository;

@Service
public class ClientService implements IClientService {
	
	@Autowired
    private ClientRepository repository;

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client update(Long id, Client client) {
        Optional<Client> existing = repository.findById(id);
        if (existing.isPresent()) {
            client.setId(id);
            return repository.save(client);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
