package Teste.Interface;

public class PessoaJuridica implements IPessoa  {

	@Override
	public void Nome(String nome) {
		System.out.println("Nome da empresa é "+ nome);
		
	}

	@Override
	public void Endereco(String endereco) {
		System.out.println("Endereço da empresa é "+ endereco);
		
	}
	
	public void cnpj(Double cnpj) {
		 System.out.println("Meu telefone é "+ cnpj);
	}

}
