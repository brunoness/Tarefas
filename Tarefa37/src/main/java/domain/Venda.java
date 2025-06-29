package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_VENDA")
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;

    public enum Status {
        INICIADA, CONCLUIDA, CANCELADA;

        public static Status getByName(String value) {
            for (Status status : Status.values()) {
                if (status.name().equals(value)) {
                    return status;
                }
            }
            return null;
        }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="venda_seq")
    @SequenceGenerator(name="venda_seq", sequenceName="sq_venda", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, unique = true, nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk", 
                foreignKey = @ForeignKey(name = "fk_venda_cliente"), 
                referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
    @JoinTable(
        name = "TB_VENDA_PRODUTO",
        joinColumns = { @JoinColumn(name = "id_venda_fk") },
        inverseJoinColumns = { @JoinColumn(name = "id_produto_fk") }
    )
    private Set<ProdutoQuantidade> produtos;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "DATA_VENDA", nullable = false)
    private Instant dataVenda;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_VENDA", nullable = false)
    private Status status;

    public Venda() {
        produtos = new HashSet<>();
    }

    public void adicionarProduto(Produto produto, Integer quantidade) {
        validarStatus();
        boolean encontrado = false;
        for (ProdutoQuantidade prod : this.produtos) {
            if (prod.getProduto().getId().equals(produto.getId())) {
                prod.adicionar(quantidade);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            ProdutoQuantidade prod = new ProdutoQuantidade();
            prod.setProduto(produto);
            prod.adicionar(quantidade);
            this.produtos.add(prod);
        }
        recalcularValorTotalVenda();
    }

    private void validarStatus() {
        if (this.status == Status.CONCLUIDA || this.status == Status.CANCELADA) {
            throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA OU CANCELADA");
        }
    }

    public void removerProduto(Produto produto, Integer quantidade) {
        validarStatus();
        ProdutoQuantidade produtoEncontrado = null;
        for (ProdutoQuantidade prod : this.produtos) {
            if (prod.getProduto().getId().equals(produto.getId())) {
                if (prod.getQuantidade() > quantidade) {
                    prod.remover(quantidade);
                    produtoEncontrado = prod;
                    break;
                } else {
                    this.produtos.remove(prod);
                    produtoEncontrado = prod;
                    break;
                }
            }
        }
        recalcularValorTotalVenda();
    }

    public void removerTodosProdutos() {
        validarStatus();
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos() {       
        int result = 0;
        for (ProdutoQuantidade prod : this.produtos) {
            result += prod.getQuantidade();
        }
        return result;
    }

    public void recalcularValorTotalVenda() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ProdutoQuantidade prod : this.produtos) {
            valorTotal = valorTotal.add(prod.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }

    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }
    public String getCodigo() { 
    	return codigo; 
    }
    public void setCodigo(String codigo) { 
    	this.codigo = codigo; 
    }
    public Cliente getCliente() { 
    	return cliente; 
    }
    public void setCliente(Cliente cliente) { 
    	this.cliente = cliente; 
    }
    public Set<ProdutoQuantidade> getProdutos() { 
    	return produtos; 
    }
    public void setProdutos(Set<ProdutoQuantidade> produtos) { 
    	this.produtos = produtos; 
    }
    public BigDecimal getValorTotal() { 
    	return valorTotal; 
    }
    public void setValorTotal(BigDecimal valorTotal) { 
    	this.valorTotal = valorTotal; 
    }
    public Instant getDataVenda() { 
    	return dataVenda; 
    }
    public void setDataVenda(Instant dataVenda) { 
    	this.dataVenda = dataVenda; 
    }
    public Status getStatus() { 
    	return status; 
    }
    public void setStatus(Status status) { 
    	this.status = status; 
    }
}

