package br.com.bruno;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String [] args) {
		List<Carro> carros = new ArrayList<>();
			carros.add(new Volkswagen("UP", 2019, 1100));
		    carros.add(new Honda("Civic", 2025, 350));
		    carros.add(new Ford("Fusion", 2010, 150));
	
		for (Carro carro : carros) {
			carro.exibirMarca();
			System.out.println("Modelo: " + carro.getModelo());
			System.out.println("Ano: " + carro.getAno());
			System.out.println("Potencia: " + carro.getPotencia() + " CV");
			System.out.println(" ");
	  }
	}
}