package domain;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
    @SequenceGenerator(name="cliente_seq", sequenceName="sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "CPF", unique = true, nullable = false)
    private Long cpf;

    @Column(name = "TELEFONE", nullable = false)
    private Long telefone;

    @Column(name = "ENDERECO", length = 100, nullable = false)
    private String endereco;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "CIDADE", length = 50, nullable = false)
    private String cidade;

    @Column(name = "ESTADO", length = 2, nullable = false)
    private String estado;

    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;

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
    public Long getCpf() { 
    	return cpf; 
    }
    public void setCpf(Long cpf) { 
    	this.cpf = cpf; 
    }
    public Long getTelefone() { 
    	return telefone; 
    }
    public void setTelefone(Long telefone) { 
    	this.telefone = telefone; 
    }
    public String getEndereco() { 
    	return endereco; 
    }
    public void setEndereco(String endereco) { 
    	this.endereco = endereco; 
    }
    public Integer getNumero() { 
    	return numero; 
    }
    public void setNumero(Integer numero) { 
    	this.numero = numero; 
    }
    public String getCidade() { 
    	return cidade; 
    }
    public void setCidade(String cidade) { 
    	this.cidade = cidade; 
    }
    public String getEstado() { 
    	return estado; 
    }
    public void setEstado(String estado) { 
    	this.estado = estado; 
    }
    public List<Venda> getVendas() { 
    	return vendas; 
    }
    public void setVendas(List<Venda> vendas) { 
    	this.vendas = vendas; 
    }
}

