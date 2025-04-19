package br.com.main;

import java.util.List;
import java.util.Objects;

public class Pessoa {

	private String nome;
	private int idade;
	private String sexo;
	
	public Pessoa (String nome, int idade, String sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public Pessoa () {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public List<Pessoa> grupoPessoas(){
		Pessoa pessoa1 = new Pessoa("Bruno Correia", 29, "Masculino");
		Pessoa pessoa2 = new Pessoa("Jacqueline Santos", 30, "Feminino");
		Pessoa pessoa3 = new Pessoa("Manuela Correia", 3, "Feminino");
		Pessoa pessoa4 = new Pessoa("Vinicius Brainer", 28, "Masculino");
		Pessoa pessoa5 = new Pessoa("Adriana Maria", 49, "Feminino");
		Pessoa pessoa6 = new Pessoa("Jorge Bezerra", 69, "Masculino");
		Pessoa pessoa7 = new Pessoa("Edmeia Germano", 79, "Feminino");
		return List.of(pessoa1,pessoa2,pessoa3,pessoa4,pessoa5,pessoa6,pessoa7);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sexo, other.sexo);
	}
	
	
}
