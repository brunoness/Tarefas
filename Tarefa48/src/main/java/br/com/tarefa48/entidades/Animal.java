package br.com.tarefa48.entidades;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	
	@Column(nullable = false)
	private String nomeProvisorio;
	
	@Column(nullable = false)
	private Integer idadeEstimada;
	
	@Column(nullable = false)
	private String raca;

	@Column(nullable = false)
	private Date dataEntrada;
	
	@Column
	private Date dataAdocao;
	
	@Column(nullable = false)
	private String condicaoChegada;
	
	@Column(nullable = false)
	private String nomeRecebedor;
	
	@Column
	private Date obito;
	
	@Column(nullable = false)
	private String porte;
	
	@Column(nullable = false)
	private String tipo;
	
	//Getters and Setters
	
	public String getNomeProvisorio() {
		return nomeProvisorio;
	}

	public void setNomeProvisorio(String nomeProvisorio) {
		this.nomeProvisorio = nomeProvisorio;
	}

	public Integer getIdadeEstimada() {
		return idadeEstimada;
	}

	public void setIdadeEstimada(Integer idadeEstimada) {
		this.idadeEstimada = idadeEstimada;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}

	public String getCondicaoChegada() {
		return condicaoChegada;
	}

	public void setCondicaoChegada(String condicaoChegada) {
		this.condicaoChegada = condicaoChegada;
	}

	public String getNomeRecebedor() {
		return nomeRecebedor;
	}

	public void setNomeRecebedor(String nomeRecebedor) {
		this.nomeRecebedor = nomeRecebedor;
	}

	public Date getObito() {
		return obito;
	}

	public void setObito(Date obito) {
		this.obito = obito;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
