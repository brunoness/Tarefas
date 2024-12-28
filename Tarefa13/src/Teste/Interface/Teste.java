package Teste.Interface;

public class Teste {

	public static void main(String[] args) {
		IPessoa pessoaf = new PessoaFisica();
		pessoaf.Nome("Bruno Correia");
		pessoaf.Endereco("Ebac");

		IPessoa pessoaj = new PessoaJuridica();
		pessoaj.Nome("Posto Shell");
		pessoaj.Endereco("Esquina da EBAC");
	}

}
