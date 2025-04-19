package br.com.test;

import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Test;

import br.com.main.Pessoa;

public class Teste1 {
	@Test
	public void teste() {
	    List<Pessoa> lista = new Pessoa().grupoPessoas();

	    List<Pessoa> pessoas = lista.stream()
	        .filter(p -> p.getSexo().equals("Feminino"))
	        .toList();

	    pessoas.forEach(p -> System.out.println(p.getNome()));
	    
	    assertTrue(pessoas.stream().allMatch(p -> p.getSexo().equals("Feminino")));
	}
}
