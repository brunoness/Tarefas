package com.br.tarefa33.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_carro")
public class Carro {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String modelo;

	    @Column(nullable = false)
	    private int ano;

	    @ManyToOne
	    @JoinColumn(name = "marca_id", nullable = false)
	    private Marca marca;

	    @ManyToMany
	    @JoinTable(
	        name = "carros_acessorios",
	        joinColumns = @JoinColumn(name = "carro_id"),
	        inverseJoinColumns = @JoinColumn(name = "acessorio_id")
	    )
	    private List<Acessorio> acessorios;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}