package tarefa22;

import java.util.List;
import java.util.stream.Stream;

public class Master {
	
	public static void main(String[] args) {
		List<Pessoa> lista = new Pessoa().grupoPessoas();
		
//           			TAREFA	
		System.out.println("TAREFA: Pessoas do Sexo Feminino:");
		lista.stream()
				.filter(pessoa -> pessoa.getSexo().equals("Feminino"))
				.forEach(pessoa -> System.out.println(pessoa.getNome()));
		
		System.out.println(" ");
		
// 					FIXANDO CONCEITOS
		Stream<String> stream1 = lista.stream()
				.filter(pessoa -> pessoa.getSexo().equals("Masculino"))
				.map(Pessoa::getNome);
		
		System.out.println("Conceito com MAP: Pessoas do Sexo Masculino:");									
		stream1.forEach(a ->System.out.println(a));
	}

}
