package br.com.bruno;

public class Volkswagen extends Carro {
    public Volkswagen(String modelo, int ano, int potencia) {
        super(modelo, ano, potencia);
    }

	@Override
	public void exibirMarca() {
		System.out.println("Volkswagen");
		
	}
}
