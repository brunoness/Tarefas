package br.com.bruno;

public class Honda extends Carro {
    public Honda(String modelo, int ano, int potencia) {
        super(modelo, ano, potencia);
    }

	@Override
	public void exibirMarca() {
		System.out.println("Honda");
		
	}
}
