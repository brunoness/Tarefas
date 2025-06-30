package controller;

import model.Cliente;
import service.ClienteService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ClienteController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
    private List<Cliente> clientes;

    @Inject
    private ClienteService clienteService;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        clientes = clienteService.listarTodos();
    }

    public void salvar() {
        clienteService.salvar(cliente);
        cliente = new Cliente(); // limpa o formulário
        clientes = clienteService.listarTodos(); // atualiza lista
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}