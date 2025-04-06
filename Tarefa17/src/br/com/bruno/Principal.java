package br.com.bruno;

public class Principal {

	public static void main(String [] args) {
		Carro<String> carro1 = new Carro<String>();
		carro1.setMarca("Honda");
		carro1.setModelo("Civic");
		carro1.setPotencia(100);
		
		System.out.println("Marca: " + carro1.getMarca());
		System.out.println("Modelo: " + carro1.getModelo());
		System.out.println("Potencia: " + carro1.getPotencia());
		
	}	
}
