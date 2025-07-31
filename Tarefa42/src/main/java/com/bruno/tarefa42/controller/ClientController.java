package com.bruno.tarefa42.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bruno.tarefa42.model.Client;
import com.bruno.tarefa42.service.ClientService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@Tag(name = "Clients", description = "Operations related to customers")
@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
    private ClientService clientService;

	@Operation(summary = "Create a new client")
    @ApiResponse(responseCode = "201", description = "Client created")
    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @Operation(summary = "Get all clients")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved clients")
    @GetMapping
    public List<Client> getAll() {
        return clientService.findAll();
    }
    
    @Operation(summary = "Update client ID") 
    @ApiResponse(responseCode = "200", description = "Client updated")
    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }
    
    @Operation(summary = "Delete a client by ID")
    @ApiResponse(responseCode = "204", description = "Client deleted")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
