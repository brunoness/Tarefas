package projeto2.domain;

public class Estoque implements Persistente {
	
	private Long id;
	private Produto produto;
	private int quantidade;
	
	public Estoque(Long id, Produto produto, int quantidade) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public Estoque() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void diminuir(int quantidadeVendida) {
        this.quantidade -= quantidadeVendida;
    }
}
