package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_qtd_seq")
    @SequenceGenerator(name="prod_qtd_seq", sequenceName="sq_produto_quantidade", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;

    public ProdutoQuantidade() {
        this.quantidade = 0;
        this.valorTotal = BigDecimal.ZERO;
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
    public Integer getQuantidade() { 
    	return quantidade; 
    }
    public void setQuantidade(Integer quantidade) { 
    	this.quantidade = quantidade; 
    }
    public BigDecimal getValorTotal() { 
    	return valorTotal; 
    }
    public void setValorTotal(BigDecimal valorTotal) { 
    	this.valorTotal = valorTotal; 
    }

    public void adicionar(Integer quantidade) {
        this.quantidade += quantidade;
        BigDecimal novoValor = this.produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.add(novoValor);
    }

    public void remover(Integer quantidade) {
        this.quantidade -= quantidade;
        BigDecimal novoValor = this.produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoValor);
    }
}

