package tarefa19;

@Tabela(nome = "Primeira anotacao")
public class Principal {
	
	public static void main(String[] args) {
		nomeDaTabela();
	}
	
	@Tabela(nome = "Teste de anotacao")
	private String teste;
	
	private static void nomeDaTabela() {
		System.out.println(Tabela.class.getName());
	}
	
}
