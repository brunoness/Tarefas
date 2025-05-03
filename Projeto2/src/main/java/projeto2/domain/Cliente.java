package projeto2.domain;

public class Cliente {
	private Long id;
    private String nome;
	private Integer cpf;
    
    public Cliente(long id, String nome, int cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}


}
