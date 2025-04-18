package br.com.bruno;

public class Ford extends Carro {
    public Ford(String modelo, int ano, int potencia) {
        super(modelo, ano, potencia);
    }

	@Override
	public void exibirMarca() {
		System.out.println("Ford");
		
	}
}
