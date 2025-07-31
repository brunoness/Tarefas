package com.bruno.tarefa42.service;

import java.util.List;
import com.bruno.tarefa42.model.Client;

public interface IClientService {
	Client save(Client client);
    Client findById(Long id);
    List<Client> findAll();
    Client update(Long id, Client client);
    void delete(Long id);

}
