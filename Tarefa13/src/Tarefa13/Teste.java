package Tarefa13;

public class Teste {

	public static void main(String[] args) {
		criandoPessoaFisica();
		criandoPessoaJuridica();
		
	}
	
	public static void criandoPessoaFisica() {
		PessoaFisica pessoaf = new PessoaFisica();
		pessoaf.setNome("Bruno Correia");
		pessoaf.setContato("123456");
		pessoaf.setCPF(3);
		pessoaf.setEmail("MeuEmail@mail");
		pessoaf.setEndereco("EBAC");
		
		System.out.println("Imprimindo PESSOA FISICA: ");
		System.out.println("Nome: "+ pessoaf.getNome());
		System.out.println("Contato: "+ pessoaf.getContato());
		System.out.println("CPF: "+ pessoaf.getCPF());
		System.out.println("Email: "+ pessoaf.getEmail());
		System.out.println("Endereco: "+ pessoaf.getEndereco());
		System.out.println(" ");
	}
	
	public static void criandoPessoaJuridica() {
		PessoaJuridica pessoaj = new PessoaJuridica();
		pessoaj.setRazaoSocial("Empresa de tecnologia - ME");
		pessoaj.setNomeFantasia("Casa do Programador");
		pessoaj.setCNPJ(45);
		pessoaj.setEndereco("EBAC");
		pessoaj.setContato("5234");
		pessoaj.setEmail("Responsavel@casadoprogramador.com");
		
		
		System.out.println("Imprimindo PESSOA JURIDICA: ");
		System.out.println("Razão Social: "+ pessoaj.getRazaoSocial());
		System.out.println("Nome Fantasia: "+ pessoaj.getNomeFantasia());
		System.out.println("CNPJ: "+ pessoaj.getCNPJ());
		System.out.println("Endereço: "+ pessoaj.getEndereco());
		System.out.println("Contato: "+ pessoaj.getContato());
		System.out.println("Email: "+ pessoaj.getEmail());
	}

}
