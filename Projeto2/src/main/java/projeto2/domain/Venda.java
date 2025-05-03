package projeto2.domain;

import java.util.List;

public class Venda {
	private Long id;
    private Cliente cliente;
    private List<Produto> produtos;
    
	public Venda(long id, Cliente cliente2, List<Produto> produtos) {
		this.id = id;
        this.cliente = cliente2;
        this.produtos = produtos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public double getTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}
