package projeto2.domain;

public class Produto implements Persistente {
	private Long id;
	private String nome;
	private Double preco;
	
	public Produto(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
	}
	
	public Produto() {
	}
	
	public Long getId() { return id; }
    public String getNome() { return nome; }
    public Double getPreco() { return preco; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(Double preco) { this.preco = preco; }
}
