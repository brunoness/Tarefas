package Teste.Interface;

public class PessoaFisica implements IPessoa {

	@Override
	public void Nome(String nome) {
		System.out.println("Meu nome é "+ nome);
		
	}

	@Override
	public void Endereco(String endereco) {
		System.out.println("Meu endereço é "+ endereco);
		
	}
	
	public void cpf(Double cpf) {
		 System.out.println("Meu telefone é "+ cpf);
	}

	public void contato(String contato) {
		 System.out.println("Meu telefone é "+ contato);
	}
	 
	 
}
